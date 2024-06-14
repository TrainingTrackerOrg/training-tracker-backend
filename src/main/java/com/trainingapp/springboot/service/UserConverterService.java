package com.trainingapp.springboot.service;

import com.trainingapp.springboot.dto.CreateUserDTO;
import com.trainingapp.springboot.dto.UserDTO;
import com.trainingapp.springboot.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserConverterService {
    public UserDTO entityToDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setFullName(user.getFullName());
        return dto;
    }

    public User dtoToEntity(CreateUserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setFullName(dto.getFullName());
        return user;
    }
}
