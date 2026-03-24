package com.example.mockito_training.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Training{

    @Id
    @GeneratedValue
    private int trainingId;

    private Date startDate, endDate;
    private String topic;
    private String trainerName;

    public Training() {
        super();
    }

    public Training(int trainingId, Date startDate, Date endDate, String topic, String trainerName) {
        super();
        this.trainingId = trainingId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.topic = topic;
        this.trainerName = trainerName;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }
}
