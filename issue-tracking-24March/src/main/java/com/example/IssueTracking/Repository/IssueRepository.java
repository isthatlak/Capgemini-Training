package com.example.IssueTracking.Repository;

import com.example.IssueTracking.Entity.Issue;
import com.example.IssueTracking.Entity.IssueStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    List<Issue> findByEmployeeIdAndStatusNot(Long employeeId, IssueStatus status);
    List<Issue> findByCreatedDateBetween(LocalDate start, LocalDate end);
}