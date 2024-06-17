package com.trainingapp.springboot.controller;

import com.trainingapp.springboot.dto.TrainingDTO;
import com.trainingapp.springboot.dto.WeeklyTrainingDTO;
import com.trainingapp.springboot.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.time.Month;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/trainings")
public class TrainingController {
    private final TrainingService trainingService;

    @PostMapping
    public TrainingDTO createTraining(@RequestBody TrainingDTO dto) {
        return trainingService.createTraining(dto);
    }

    @GetMapping("/all-by-user-id/{id}")
    public List<TrainingDTO> getAllByUserId(@PathVariable Long id) {
        return trainingService.getAllByUserId(id);
    }

    @GetMapping("/all-by-month/{month}/{week}/{id}/{year}")
    public WeeklyTrainingDTO getAllByMonth(@PathVariable Month month, @PathVariable int week, @PathVariable Long id,@PathVariable Long year) {
        return trainingService.weeklyTrainingData(month,week,id,year);
    }
}
