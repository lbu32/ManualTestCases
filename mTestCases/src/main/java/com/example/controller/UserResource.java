package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/rest")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/users")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }


    @RequestMapping(value = "/user/email", method = RequestMethod.POST)
    public User findByEmail(@RequestBody String email) {
        System.out.println(email);
        System.out.println(userService.findByEmail(email));
        return userService.findByEmail(email);
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public User updateUser(@RequestBody User user) {
        return userService.save(user);
    }
}
