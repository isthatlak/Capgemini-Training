package com.example.mockito_training.repository;

import com.example.mockito_training.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //converts sql exception to runtimeexception
public interface TrainingRepo extends JpaRepository<Training, Integer> {

}
