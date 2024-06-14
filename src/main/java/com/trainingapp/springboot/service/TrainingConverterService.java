package com.trainingapp.springboot.service;

import com.trainingapp.springboot.dto.TrainingDTO;
import com.trainingapp.springboot.model.Training;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class TrainingConverterService {
    private final UserService userService;
    public TrainingDTO entityToDto(Training training) {
        TrainingDTO dto = new TrainingDTO();
        dto.setName(training.getName());
        dto.setDuration(training.getDuration());
        dto.setFatigue(training.getFatigue());
        dto.setStart(training.getStart());
        dto.setCaloriesLost(training.getCaloriesLost());
        dto.setExerciseType(training.getExerciseType());
        dto.setTrainingIntensity(training.getTrainingIntensity());
        dto.setCreatorId(training.getCreator().getId());
        return dto;
    }
    public Training dtoToEntity(TrainingDTO dto) {
        Training training = new Training();
        training.setName(dto.getName());
        training.setDuration(dto.getDuration());
        training.setFatigue(dto.getFatigue());
        training.setStart(dto.getStart());
        training.setTrainingIntensity(dto.getTrainingIntensity());
        training.setCreator(userService.getUserById(dto.getCreatorId()));
        training.setCaloriesLost(dto.getCaloriesLost());
        training.setExerciseType(dto.getExerciseType());
        return training;
    }
}
