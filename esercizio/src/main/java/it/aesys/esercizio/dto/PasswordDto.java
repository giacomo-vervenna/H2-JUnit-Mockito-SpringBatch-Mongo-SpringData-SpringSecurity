package it.aesys.esercizio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordDto {
    private String newPassword;
    private String oldPassword;
}
