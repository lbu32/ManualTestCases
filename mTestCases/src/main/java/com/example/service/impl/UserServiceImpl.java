package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public User save(User user) {
        return userDao.save(user);
    }

    public User findByUserId(int userId) { return userDao.findByUserId(userId);}


}