package com.example.password_manager.service.impl;

import com.example.password_manager.entities.Password;
import com.example.password_manager.entities.User;
import com.example.password_manager.entities.dto.request_dto.PasswordRequest;
import com.example.password_manager.entities.dto.request_dto.UserRequest;
import com.example.password_manager.repository.UserRepository;
import com.example.password_manager.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void createUser(UserRequest userRequest) {
        User user = new User();
        mapper.map(userRequest, user);
        repo.save(user);
    }

    public void addPassword(PasswordRequest pwdRequest, String username) {
       Optional<User> user = repo.findByUsername(username);
        Password pwd = new Password();
        mapper.map(pwdRequest, pwd);
        user.get().getPasswords().add(pwd);
        repo.save(user.get());
    }
}
