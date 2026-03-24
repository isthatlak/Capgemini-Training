package com.example.mockito_training.service;

import java.util.List;

import com.example.mockito_training.dto.TrainingDTO;
import com.example.mockito_training.model.Training;
import org.springframework.stereotype.Service;

@Service
public class TrainingServiceImpl implements TrainingService {
    @Override
    public List<Training> findByTopic(String topic) {
        return List.of();
    }

    @Override
    public TrainingDTO findById(int trainingid) {
        return null;
    }

    @Override
    public Training addTraining(Training training) {
        return null;
    }

    @Override
    public Training updateTraining(Training training) {
        return null;
    }

    @Override
    public boolean deleteTraining(int trainingid) {
        return false;
    }
}
