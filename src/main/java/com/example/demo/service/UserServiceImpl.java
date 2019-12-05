package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User findUserByName(String name)
    {
        return userRepository.findByName(name);
    }

    public void saveUser(User user)
    {
        userRepository.save(user);
    }
}
