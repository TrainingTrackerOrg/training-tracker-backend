package com.trainingapp.springboot.controller;

import com.trainingapp.springboot.dto.JwtDTO;
import com.trainingapp.springboot.dto.LoginDTO;
import com.trainingapp.springboot.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/login")
public class LoginController {
    private final AuthenticationService authenticationService;

    @PostMapping("/authentication")
    public JwtDTO login(@RequestBody LoginDTO loginRequest) {
        String accessToken = authenticationService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        return new JwtDTO(accessToken);
    }
}
