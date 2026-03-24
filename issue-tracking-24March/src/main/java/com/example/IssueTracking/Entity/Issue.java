package com.example.IssueTracking.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private IssueCategory category;

    @Enumerated(EnumType.STRING)
    private IssueStatus status;

    private LocalDate createdDate;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @ToString.Exclude
    private Employee employee;

}