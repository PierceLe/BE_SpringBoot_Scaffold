package com.scaffold.spring_boot.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserCreationRequest {
    @Size(min = 3, message = "username must be at least 3 characters")
    private String username;

    @Size(min = 8, message = "password must be at least 8 characters")
    private String password;
    private String firstName;
    private String lastName;

    private LocalDate dob;
}
