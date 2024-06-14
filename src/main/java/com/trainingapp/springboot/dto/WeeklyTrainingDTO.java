package com.trainingapp.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeeklyTrainingDTO {
    private int weeklyDuration;
    private int numberOfTrainings;
    private double avgFatigue;
    private double avgIntensity;
}
