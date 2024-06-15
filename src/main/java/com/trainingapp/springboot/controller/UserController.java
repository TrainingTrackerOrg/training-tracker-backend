package com.trainingapp.springboot.controller;

import com.trainingapp.springboot.dto.CreateUserDTO;
import com.trainingapp.springboot.dto.UserDTO;
import com.trainingapp.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserDTO createUser(@RequestBody CreateUserDTO user) {
        return userService.createUser(user);
    }


}
