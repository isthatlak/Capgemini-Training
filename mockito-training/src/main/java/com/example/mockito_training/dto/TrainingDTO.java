package com.example.mockito_training.dto;

import com.example.mockito_training.model.Training;

import java.sql.Date;

public class TrainingDTO {
    int trainingId;
    Date startDate;
    Date endDate;
    String topic;


    public TrainingDTO(Training training) {
        this.endDate = training.getEndDate();
        this.startDate = training.getStartDate();
        this.trainingId = training.getTrainingId();
        this.topic = training.getTopic();
    }

    @Override
    public String toString() {
        return "TrainingDTO{" +
                "endDate=" + endDate +
                ", trainingId=" + trainingId +
                ", startDate=" + startDate +
                ", topic='" + topic + '\'' +
                '}';
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
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

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }
}
