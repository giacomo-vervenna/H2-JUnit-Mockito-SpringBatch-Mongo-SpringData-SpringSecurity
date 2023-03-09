package com.example.password_manager.entities.dto.response_dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PasswordResponse {

    private String site;
    private String siteUsername;
    private String sitePassword;
}
