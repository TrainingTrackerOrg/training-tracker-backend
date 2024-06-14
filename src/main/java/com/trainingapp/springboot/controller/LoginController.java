package com.trainingapp.springboot.controller;

import com.trainingapp.springboot.dto.LoginDTO;
import com.trainingapp.springboot.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
public class LoginController {
    private final AuthenticationService authenticationService;

    @PostMapping("/authentication")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginRequest) {
        boolean isAuthenticated = authenticationService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}
