package com.example.service;

import com.example.dto.request.LoginRequest;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService{

    private final UserRepository userRepository;

    @Override
    public String loginAccount(LoginRequest loginRequest) {

        return "";
    }
}
