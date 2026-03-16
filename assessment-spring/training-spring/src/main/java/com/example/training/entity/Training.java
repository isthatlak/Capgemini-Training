package com.example.training.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainingid;

    private String topic;

    private LocalDate startDate;

    private LocalDate endDate;

    private String trainername;

    private String venue;

    public Training(){}

    public Long getTrainingid() {
        return trainingid;
    }

    public void setTrainingid(Long trainingid) {
        this.trainingid = trainingid;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getTrainername() {
        return trainername;
    }

    public void setTrainername(String trainername) {
        this.trainername = trainername;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
