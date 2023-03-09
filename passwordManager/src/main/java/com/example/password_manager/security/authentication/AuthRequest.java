package com.example.password_manager.security.authentication;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthRequest {

    @NonNull
    private String username;

    @NonNull
    private String password;
}
