package com.trainingapp.springboot.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.trainingapp.springboot.model.User;
import com.trainingapp.springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public String authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return null;
        }
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword().toCharArray());
        if(result.verified){
            Map<String, Object> extraClaims = new HashMap<>();
            extraClaims.put("userId", user.getId());
            return jwtService.generateToken(extraClaims,user);
        }
        return null;
    }
}
