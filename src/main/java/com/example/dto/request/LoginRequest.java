package com.example.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @Email(message = "invalid email format")
    @NotBlank(message = "email cannot be blank")
    private String emailId;
    @NotBlank(message = "password cannot be blank")
    @Size(min = 8, max = 12, message = "password cannot be blank")
    private String password;
}
