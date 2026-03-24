package com.example.mockito_training.service;

import java.util.List;

import com.example.mockito_training.dto.TrainingDTO;
import com.example.mockito_training.model.Training;

public interface TrainingService {
    List<Training> findByTopic(String topic);
    TrainingDTO findById(int trainingid);
    Training addTraining(Training training);
    Training updateTraining(Training training);
    boolean deleteTraining(int trainingid);
}
