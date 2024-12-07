package com.scaffold.spring_boot.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserCreationRequest {
    @Size(min = 3, message = "USER_NAME_NOT_VALID")
    private String username;

    @Size(min = 8, message = "USER_PASSWORD_NOT_VALID")
    private String password;
    private String firstName;
    private String lastName;

    private LocalDate dob;
}
