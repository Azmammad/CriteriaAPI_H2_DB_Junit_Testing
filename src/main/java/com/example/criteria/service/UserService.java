package com.example.criteria.service;

import com.example.criteria.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    void deleteUser(Long id);
    List<User> searchUsers(String username,Integer age);
}
