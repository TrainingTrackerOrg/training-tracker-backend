package com.trainingapp.springboot.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.trainingapp.springboot.model.User;
import com.trainingapp.springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    public boolean authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return false;
        }
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword().toCharArray());
        return result.verified;
    }
}
