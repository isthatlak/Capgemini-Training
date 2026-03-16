package com.example.training.repository;

import com.example.training.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TrainingRepository extends JpaRepository<Training, Long> {

    List<Training> findByEndDateAfter(LocalDate today);

    List<Training> findByEndDateAfterAndTopicContainingIgnoreCase(LocalDate today,String topic);

    List<Training> findByStartDateAfterAndTopicContainingIgnoreCase(LocalDate today,String topic);

}
