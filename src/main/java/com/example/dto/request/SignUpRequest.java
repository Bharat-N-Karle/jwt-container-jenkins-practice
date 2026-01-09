package com.example.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpRequest {

    @NotBlank(message = "firstName cannot be blank")
    private String firstName;
    @NotBlank(message = "lastName cannot be blank")
    private String lastName;
    @Email(message = "invalid email format")
    @NotBlank(message = "email cannot be blank")
    private String emailId;
    @NotBlank(message = "password cannot be blank")
    @Size(min = 8, max = 12, message = "password cannot be blank")
    private String password;
}
