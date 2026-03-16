package com.example.training.controller;

import com.example.training.entity.Training;
import com.example.training.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainingController {

    @Autowired
    private TrainingService service;

    @GetMapping("/trainings")
    public List<Training> getTrainings(@RequestParam(required=false) String name){

        if(name == null)
            return service.getCurrentAndUpcoming();

        return service.searchTrainings(name);
    }

    @GetMapping("/trainings/upcoming")
    public List<Training> upcomingTrainings(@RequestParam String name){
        return service.upcomingTrainings(name);
    }
}
