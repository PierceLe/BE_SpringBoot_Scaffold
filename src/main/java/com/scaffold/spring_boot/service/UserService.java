package com.scaffold.spring_boot.service;


import com.scaffold.spring_boot.dto.request.UserCreationRequest;
import com.scaffold.spring_boot.dto.request.UserUpdateRequest;
import com.scaffold.spring_boot.entity.Users;
import com.scaffold.spring_boot.exception.AppException;
import com.scaffold.spring_boot.exception.ErrorCode;
import com.scaffold.spring_boot.mapper.UserMapper;
import com.scaffold.spring_boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public Users createUser(UserCreationRequest request) {
        Users user = new Users();

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

//        user.setUsername(request.getUsername());
//        user.setPassword(request.getPassword());
//        user.setDob(request.getDob());
//        user.setFirstName(request.getFirstName());
//        user.setLastName(request.getLastName(
// ------- same with this line----------------------------
        user = userMapper.toUser(request);


        return userRepository.save(user);
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user not found"));
    }

    public Users updateUser(String id, UserUpdateRequest request) {
        Users user = getUserById(id);
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDob(request.getDob());
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
