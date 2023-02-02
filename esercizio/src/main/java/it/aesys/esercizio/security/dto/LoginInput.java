package it.aesys.esercizio.security.dto;

import lombok.Data;

@Data
public class LoginInput {

    private String fiscalCode;
    private String password;
}
