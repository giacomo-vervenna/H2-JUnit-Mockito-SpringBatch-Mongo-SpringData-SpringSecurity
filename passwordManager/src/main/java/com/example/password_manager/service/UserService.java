package com.example.password_manager.service;

import com.example.password_manager.entities.dto.request_dto.PasswordRequest;
import com.example.password_manager.entities.dto.request_dto.UserRequest;

public interface UserService {

    void createUser(UserRequest userRequest);
    void addPassword(PasswordRequest pwdRequest, String username);
}
