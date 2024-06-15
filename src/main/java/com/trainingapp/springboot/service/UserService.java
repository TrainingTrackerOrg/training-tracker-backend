package com.trainingapp.springboot.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.trainingapp.springboot.dto.CreateUserDTO;
import com.trainingapp.springboot.dto.UserDTO;
import com.trainingapp.springboot.exception.RegistrationException;
import com.trainingapp.springboot.model.User;
import com.trainingapp.springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserConverterService userConverterService;


    public UserDTO createUser(CreateUserDTO newUser) {
        List<User> allUsers = userRepository.findAll();
        allUsers.forEach(user -> {
            if (newUser.getUsername().equals(user.getUsername())) {
                throw new RegistrationException(newUser.getUsername());
            }
        });
        String hashedPassword = BCrypt.withDefaults().hashToString(12, newUser.getPassword().toCharArray());
        newUser.setPassword(hashedPassword);
        User user = userRepository.save(userConverterService.dtoToEntity(newUser));
        return userConverterService.entityToDto(user);
    }

    public User getUserById(Long id) {
        return  userRepository.findById(id).orElse(null);
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> this.userRepository.findByUsername(username);
    }
}
