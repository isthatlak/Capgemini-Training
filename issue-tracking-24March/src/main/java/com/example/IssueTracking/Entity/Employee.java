package com.example.IssueTracking.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Double salary;
    private String department;
    private LocalDate startDate;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Issue> issues;
}