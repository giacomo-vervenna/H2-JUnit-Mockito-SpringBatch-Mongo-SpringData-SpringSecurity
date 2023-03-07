package com.example.passwordManager.controller;

import com.example.passwordManager.entities.User;
import com.example.passwordManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User user){
        service.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
