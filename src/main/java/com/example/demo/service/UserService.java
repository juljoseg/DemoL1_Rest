package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    public User findUserByName(String name);

    public void saveUser(User user);
}
