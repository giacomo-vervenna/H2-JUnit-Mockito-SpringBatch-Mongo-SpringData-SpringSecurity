package com.example.password_manager.controller;

import com.example.password_manager.entities.dto.request_dto.PasswordRequest;
import com.example.password_manager.entities.dto.request_dto.UserRequest;
import com.example.password_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public ResponseEntity<Void> createUser(@RequestBody UserRequest user){
        service.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> addPassword(@RequestBody PasswordRequest pwdReq, @RequestHeader(value = "Authorization") String authHeader) {
        return null; //TODO bestemmie
    }
}
