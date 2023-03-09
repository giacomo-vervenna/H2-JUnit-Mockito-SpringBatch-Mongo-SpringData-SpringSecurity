package com.example.password_manager.entities.dto.request_dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {

    private String username;
    private String pwd;
    private List<PasswordRequest> passwords;
}
