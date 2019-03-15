package com.example.controller;


import com.example.model.Project;
import com.example.model.User;
import com.example.service.NotificationService;
import com.example.service.ProjectService;
import com.example.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private NotificationService notificationService;


    @RequestMapping(value="login", method = RequestMethod.POST)
    public String login(@RequestBody Map<String, String> json) throws
            ServletException {
        if(json.get("email") == null || json.get("password") ==null) {
            throw new ServletException("Please fill in email and password");
        }

        String email = json.get("email");
        String password = MD5(json.get("password"));

        User user= userService.findByEmail(email);
        if (user==null) {
            throw new ServletException("Email not found.");
        }

        String pwd = user.getPassword();


        if(!password.equals(pwd)) {
            throw new ServletException("Invalid login. Please check your name and password");
        }

        String token = Jwts.builder().setSubject(user.getFirstName()).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();


        String response = "{\"id\": "+user.getUserId()+", \"email\": \""+user.getEmail()+"\", \"firstName\": \""+user.getFirstName()+"\"," +
                " \"lastName\": \""+user.getLastName()+"\", \"token\": \""+token+"\", \"companyAffiliation\": \"" + user.getCompanyAffiliation().getProjectName() + "\"}";

        return response;


    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User registerUser(@RequestBody Map<String, String> json) {

        User user = new User();
        user.setEmail(json.get("email"));
        SecureRandom random = new SecureRandom();
        String pwd = new BigInteger(130, random).toString(32);

        String pwdHash = MD5(pwd);

        user.setPassword(pwdHash);

        User u2 = userService.findByEmail(user.getEmail());

        if(u2 == null) {

            try {
                notificationService.sendNotification(user, pwd);
            } catch (MailException e) {
                System.out.println("Sending Email Error: " + e);
            }

            user.setFirstName(json.get("firstName"));
            user.setLastName(json.get("lastName"));

            int proj_Id = Integer.parseInt(json.get("companyAffiliation"));
            Project project = projectService.findById(proj_Id);
            user.setCompanyAffiliation(project);

            userService.save(user);

            return user;

        } else {
            System.out.println("User already exists");
            return null;
        }
    }

    @RequestMapping(value="/updateUser", method = RequestMethod.POST)
    public User updateUser(@RequestBody User user) {
        User userToUpdate = userService.findByUserId(user.getUserId());
        User userWithSameEmail = userService.findByEmail(user.getEmail());
        if(userWithSameEmail == null || (userWithSameEmail.getEmail().equals(user.getEmail()))){
            userToUpdate.setFirstName(user.getFirstName());
            userToUpdate.setLastName(user.getLastName());
            userToUpdate.setEmail(user.getEmail());
            System.out.println("User updated");
            return userService.save(userToUpdate);
        } else {
            System.out.println("email already exists with other user");
            return null;
        }
    }

    @RequestMapping(value="/changePwd", method = RequestMethod.POST)
    public User changePassword(@RequestBody Map<String, String> json) throws
            ServletException {

        String email = json.get("email");
        User user = userService.findByEmail(email);

        String oldPwd = MD5(json.get("oldPassword"));
        String currentPwd = user.getPassword();

        if(!oldPwd.equals(currentPwd)) {
            throw new ServletException("Invalid old Password.");
        }

        String pwd = json.get("newPassword");
        String pwdHash = MD5(pwd);

        user.setPassword(pwdHash);
        userService.save(user);

        return user;
    }


    public String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }


}