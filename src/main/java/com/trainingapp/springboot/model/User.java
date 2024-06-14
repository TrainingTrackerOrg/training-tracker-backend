package com.trainingapp.springboot.model;

import com.trainingapp.springboot.dto.CreateUserDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String username;
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Training> trainingList;

}
