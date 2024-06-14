package com.trainingapp.springboot.model;

import com.trainingapp.springboot.enums.ExerciseType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.time.Duration;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private ExerciseType exerciseType;
    private Long duration;
    private LocalDateTime start;
    private Long caloriesLost;
    @Min(1)
    @Max(10)
    private Integer trainingIntensity;
    @Min(1)
    @Max(10)
    private Integer fatigue;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user_id")
    private User creator;
}
