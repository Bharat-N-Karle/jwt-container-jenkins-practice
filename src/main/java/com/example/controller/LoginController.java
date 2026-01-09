package com.example.controller;

import com.example.dto.request.LoginRequest;
import com.example.dto.request.SignUpRequest;
import com.example.dto.response.LoginResponse;
import com.example.service.LoginService;
import com.example.service.SignUpService;
import com.example.util.JwtHelper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/login")
public class LoginController {

    private final LoginService service;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmailId(),loginRequest.getPassword()));
        String token = JwtHelper.generateToken(loginRequest.getEmailId());
        return ResponseEntity.ok(new LoginResponse(loginRequest.getEmailId(), token));
    }

    @GetMapping("/demo")
    public String demo(){
        return "welcome to demo code";
    }
}
