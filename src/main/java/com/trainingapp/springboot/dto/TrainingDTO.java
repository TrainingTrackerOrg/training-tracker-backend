package com.trainingapp.springboot.dto;

import com.trainingapp.springboot.enums.ExerciseType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainingDTO {
    private String name;
    private ExerciseType exerciseType;
    private Long duration;
    private LocalDateTime start;
    private Long caloriesLost;
    private Integer trainingIntensity;
    private Integer fatigue;
    private Long creatorId;
}
