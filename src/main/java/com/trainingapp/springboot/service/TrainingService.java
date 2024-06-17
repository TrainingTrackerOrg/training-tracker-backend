package com.trainingapp.springboot.service;

import com.trainingapp.springboot.dto.TrainingDTO;
import com.trainingapp.springboot.dto.WeeklyTrainingDTO;
import com.trainingapp.springboot.model.Training;
import com.trainingapp.springboot.repository.TrainingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RequiredArgsConstructor
@Service
public class TrainingService {
    private final TrainingRepository trainingRepository;
    private final TrainingConverterService trainingConverterService;


    public TrainingDTO createTraining(TrainingDTO dto) {
        Training training = trainingConverterService.dtoToEntity(dto);
        Training savedTraining = trainingRepository.save(training);
        return trainingConverterService.entityToDto(savedTraining);
    }

    public List<TrainingDTO> getAllByUserId(Long id) {
        List<Training> trainings = trainingRepository.findByCreatorId(id);
        List<TrainingDTO> trainingsFinal = new ArrayList<>();
        trainings.forEach(training -> {
            trainingsFinal.add(trainingConverterService.entityToDto(training));
        });
        return trainingsFinal;
    }

    public WeeklyTrainingDTO weeklyTrainingData(Month month, int week, Long id, Long year) {
        List<Training> trainings = trainingRepository.findByCreatorId(id);
        List<TrainingDTO> trainingsFinal = new ArrayList<>();
        trainings.forEach(training -> {

            int day = training.getStart().getDayOfMonth();
            if(training.getStart().getMonth().equals(month) && training.getStart().getYear() == year) {
                switch (week) {
                    case 1:
                        if(day<=7) {
                            trainingsFinal.add(trainingConverterService.entityToDto(training));
                        }
                        break;
                    case 2:
                        if(day>7 && day<=14) {
                            trainingsFinal.add(trainingConverterService.entityToDto(training));
                        }
                        break;
                    case 3:
                        if(day>14 && day<=21) {
                            trainingsFinal.add(trainingConverterService.entityToDto(training));
                        }
                        break;
                    case 4:
                        if(day>21 && day<=28) {
                            trainingsFinal.add(trainingConverterService.entityToDto(training));
                        }
                        break;
                    case 5:
                        if(day>28) {
                            trainingsFinal.add(trainingConverterService.entityToDto(training));
                        }
                        break;
                }
            }
        });
        WeeklyTrainingDTO weeklyTrainingDTO = calculateWeeklyData(trainingsFinal);
        return weeklyTrainingDTO;
    }

    public WeeklyTrainingDTO calculateWeeklyData(List<TrainingDTO> trainings) {
        WeeklyTrainingDTO weeklyTrainingDTO = new WeeklyTrainingDTO();
        int trainingDuration = 0;
        int fatigue = 0;
        int intensity = 0;
        weeklyTrainingDTO.setNumberOfTrainings(trainings.size());
        for (TrainingDTO trainingObject : trainings) {
            trainingDuration += trainingObject.getDuration();
            fatigue += trainingObject.getFatigue();
            intensity += trainingObject.getTrainingIntensity();
        }
        weeklyTrainingDTO.setWeeklyDuration(trainingDuration);
        weeklyTrainingDTO.setAvgFatigue(1.0*fatigue/trainings.size());
        weeklyTrainingDTO.setAvgIntensity(intensity/(double)trainings.size());
        return weeklyTrainingDTO;
    }
}
