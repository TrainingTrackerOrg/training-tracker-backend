package com.trainingapp.springboot.controller;

import com.trainingapp.springboot.dto.CreateUserDTO;
import com.trainingapp.springboot.dto.LoginDTO;
import com.trainingapp.springboot.dto.UserDTO;
import com.trainingapp.springboot.model.User;
import com.trainingapp.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserDTO user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }


}
