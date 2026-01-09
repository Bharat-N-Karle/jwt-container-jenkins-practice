package com.example.controller;

import com.example.dto.request.SignUpRequest;
import com.example.service.SignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/signup")
public class SignUpController {

    private final SignUpService service;

    @PostMapping("/")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpRequest request){
        return ResponseEntity.ok(service.createAccount(request));
    }
}
