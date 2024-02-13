package com.example.diplomaprojectbackend.mapper;

import com.example.diplomaprojectbackend.controller.resource.RegisterUserRequest;
import com.example.diplomaprojectbackend.controller.resource.UserResponse;
import com.example.diplomaprojectbackend.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);
    User fromRegisterUserRequest(RegisterUserRequest userRequest);
    UserResponse toUserResponse(User user);
}
