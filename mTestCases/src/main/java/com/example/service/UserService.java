package com.example.service;


import com.example.model.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    User findByEmail(String email);

    User save(User user);

    User findByUserId(int userId);

}
