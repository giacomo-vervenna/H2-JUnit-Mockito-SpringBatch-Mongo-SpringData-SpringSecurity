package com.example.passwordManager.service.impl;

import com.example.passwordManager.entities.User;
import com.example.passwordManager.repository.UserRepository;
import com.example.passwordManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public void createUser(User user) {
        repo.save(user);
    }
}
