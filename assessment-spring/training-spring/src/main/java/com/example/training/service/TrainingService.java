package com.example.training.service;

import com.example.training.entity.Training;
import com.example.training.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TrainingService {

    @Autowired
    private TrainingRepository repository;

    public List<Training> getCurrentAndUpcoming() {
        return repository.findByEndDateAfter(LocalDate.now());
    }

    public List<Training> searchTrainings(String topic) {
        return repository.findByEndDateAfterAndTopicContainingIgnoreCase(LocalDate.now(),topic);
    }

    public List<Training> upcomingTrainings(String topic) {
        return repository.findByStartDateAfterAndTopicContainingIgnoreCase(LocalDate.now(),topic);
    }
}
