package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tnlUser")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String lastName;
    private String emailId;
    private String password;
    private Long mobileNo;
}
