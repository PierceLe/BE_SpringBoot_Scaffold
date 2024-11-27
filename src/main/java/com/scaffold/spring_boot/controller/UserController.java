package com.scaffold.spring_boot.controller;

import com.scaffold.spring_boot.dto.request.UserCreationRequest;
import com.scaffold.spring_boot.dto.request.UserUpdateRequest;
import com.scaffold.spring_boot.entity.Users;
import com.scaffold.spring_boot.service.UserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public Users createUser(@RequestBody UserCreationRequest userCreationRequest) {
        return userService.createUser(userCreationRequest);
    }

    @GetMapping
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public Users getUserById(
            @PathVariable @NonNull String id
    ) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public Users updateUser(
            @PathVariable @NonNull String id,
            @RequestBody UserUpdateRequest userUpdateRequest
    ) {
        return userService.updateUser(id, userUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(
            @PathVariable @NonNull String id
    ) {
        userService.deleteUser(id);
    }
}
