package it.aesys.esercizio.security.dto;

import lombok.Data;

@Data
public class LoginCredentials {

    private String fiscalCode;
    private String password;
}
