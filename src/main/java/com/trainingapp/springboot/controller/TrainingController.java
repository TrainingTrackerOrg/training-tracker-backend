package com.trainingapp.springboot.controller;

import com.trainingapp.springboot.dto.TrainingDTO;
import com.trainingapp.springboot.dto.WeeklyTrainingDTO;
import com.trainingapp.springboot.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Month;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping("/trainings")
public class TrainingController {
    private final TrainingService trainingService;

    @PostMapping
    public ResponseEntity<TrainingDTO> createTraining(@RequestBody TrainingDTO dto) {
        return new ResponseEntity<>(trainingService.createTraining(dto), HttpStatus.OK);
    }

    @GetMapping("/all-by-user-id/{id}")
    public ResponseEntity<List<TrainingDTO>> getAllByUserId(@PathVariable Long id) {
        return new ResponseEntity<>(trainingService.getAllByUserId(id), HttpStatus.OK);
    }

    @GetMapping("/all-by-month/{month}/{week}/{id}")
    public ResponseEntity<WeeklyTrainingDTO> getAllByMonth(@PathVariable Month month, @PathVariable int week, @PathVariable Long id) {
        return new ResponseEntity<>(trainingService.weeklyTrainingData(month,week,id), HttpStatus.OK);
    }
}
