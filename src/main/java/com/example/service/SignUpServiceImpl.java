package com.example.service;

import com.example.dto.request.SignUpRequest;
import com.example.exception.DuplicateEmailException;
import com.example.model.User;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService{

    private final UserRepository userRepository;

    @Override
    public String createAccount(SignUpRequest request) {
        Optional<User> byEmailId = userRepository.findByEmailId(request.getEmailId());
        if(byEmailId.isPresent()){
            throw new DuplicateEmailException("account with the given mail id available");
        }
        userRepository.save(
                User.builder()
                        .firstName(request.getFirstName())
                        .lastName(request.getLastName())
                        .emailId(request.getEmailId())
                        .password(new BCryptPasswordEncoder().encode(request.getPassword()))
                        .build()
        );
        return "Account Created Successfully";
    }
}
