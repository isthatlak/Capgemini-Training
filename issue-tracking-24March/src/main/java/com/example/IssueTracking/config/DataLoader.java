package com.example.IssueTracking.config;

import com.example.IssueTracking.Entity.*;
import com.example.IssueTracking.Repository.EmployeeRepository;
import com.example.IssueTracking.Repository.IssueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final IssueRepository issueRepository;

    @Override
    public void run(String... args) {

        Employee emp1 = new Employee(
                null,
                "Shreya",
                "shreya@gmail.com",
                1200000.0,
                "Data Science",
                LocalDate.of(2025, 8, 5),
                null
        );

        Employee emp2 = new Employee(
                null,
                "Rahul",
                "rahul@gmail.com",
                800000.0,
                "Cloud",
                LocalDate.of(2025, 12, 9),
                null
        );

        Issue issue1 = new Issue(
                null,
                "Cannot access dashboard",
                IssueCategory.ACCESS_PERMISSION,
                IssueStatus.OPEN,
                LocalDate.now(),
                emp1
        );

        Issue issue2 = new Issue(
                null,
                "AWS instance not working",
                IssueCategory.CLOUD_ISSUE,
                IssueStatus.IN_PROGRESS,
                LocalDate.now(),
                emp2
        );

        Issue issue3 = new Issue(
                null,
                "Laptop not booting",
                IssueCategory.DESKTOP_ISSUE,
                IssueStatus.RESOLVED,
                LocalDate.now().minusDays(10),
                emp1
        );

        emp1.setIssues(List.of(issue1, issue3));
        emp2.setIssues(List.of(issue2));

        employeeRepository.saveAll(List.of(emp1, emp2));

        System.out.println("Sample Data Loaded Successfully!");
    }
}