package com.trainingapp.springboot.repository;

import com.trainingapp.springboot.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
    List<Training> findByCreatorId(Long creatorId);
}
