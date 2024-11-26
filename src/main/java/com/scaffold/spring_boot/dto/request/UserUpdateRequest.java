package com.scaffold.spring_boot.dto.request;

import jakarta.annotation.Nullable;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
public class UserUpdateRequest {
    @Nullable
    private String password;
    @Nullable
    private String firstName;
    @Nullable
    private String lastName;
    @Nullable
    private LocalDate dob;
}
