package com.scaffold.spring_boot.mapper;

import com.scaffold.spring_boot.dto.request.UserCreationRequest;
import com.scaffold.spring_boot.entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Users toUser(UserCreationRequest request);
}
