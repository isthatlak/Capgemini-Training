package com.example.mockito_training.controller;

import com.example.mockito_training.dto.TrainingDTO;
import com.example.mockito_training.model.Training;
import com.example.mockito_training.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/training")
public class TrainingController {
    private TrainingService trainingService;

    @Autowired
    public TrainingController(TrainingService trainingService){
        super();
        this.trainingService = trainingService;
    }

    @GetMapping("/{trainingId}")             // if ?trainingid = 34 RequestParam, HeaderParam, CookieParam
    TrainingDTO findById(@PathVariable("trainingId") int trainingId){
        TrainingDTO training = trainingService.findById(trainingId);
        return training;
    }
}
