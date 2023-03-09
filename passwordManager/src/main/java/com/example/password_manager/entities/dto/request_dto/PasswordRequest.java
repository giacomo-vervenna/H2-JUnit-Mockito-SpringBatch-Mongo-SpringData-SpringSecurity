package com.example.password_manager.entities.dto.request_dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PasswordRequest {

    private String site;
    private String siteUsername;
    private String sitePassword;
}
