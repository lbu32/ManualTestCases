package com.example.dao;


import com.example.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository <User, Long> {
    List<User> findAll();

    User findByEmail(String email);

    User findByFirstName(String firstName);

    User findByUserId(int userId);

    User save(User user);

}