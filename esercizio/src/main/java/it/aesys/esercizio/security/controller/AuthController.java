package it.aesys.esercizio.security.controller;

import it.aesys.esercizio.dto.AdminDtoRequest;
import it.aesys.esercizio.entities.Admin;
import it.aesys.esercizio.repositories.AdminRepository;
import it.aesys.esercizio.security.JWTUtil;
import it.aesys.esercizio.security.dto.LoginCredentials;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AdminRepository repo;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper mapper;

    @PostMapping("/register")
    public Map<String, Object> registerHandler(@RequestBody AdminDtoRequest request) {
        Admin model = new Admin();
        String encodedPass =
                passwordEncoder.encode((request.getPassword()));
        mapper.map(request, model);
        model.setPassword(encodedPass);
        repo.save(model);
        String token = jwtUtil.generateToken(model.getFiscalCode());
        return Collections.singletonMap("jwt-token", token);
    }

    @PostMapping("/login")
    public Map<String, Object> loginHandler(@RequestBody LoginCredentials body) {
        try {
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(body.getFiscalCode(), body.getPassword());
            authManager.authenticate(authInputToken);

            String token = jwtUtil.generateToken(body.getFiscalCode());

            return Collections.singletonMap("jwt-token", token);
        } catch (AuthenticationException authExc) {
            throw new RuntimeException("Invalid Login Credentials");
        }
    }
}
