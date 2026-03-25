package com.gal.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer projectId;

    private String title;
    private String client;
    private LocalDate startdate;
    private LocalDate enddate;
    private double budget;

    @OneToOne
    @JoinColumn(name = "project_manager_id")
    private Employee projectManager;

    @ManyToMany
    @JoinTable(name = "project_employee", joinColumns = {@JoinColumn(name="projectid")}, inverseJoinColumns = {@JoinColumn(name = "employeeid")})
    List<Employee> employees = new ArrayList<>();

    public Project() {}

    public Project(String title, String client,
                   LocalDate startdate, LocalDate enddate,
                   double budget, Employee projectManager) {

        this.title = title;
        this.client = client;
        this.startdate = startdate;
        this.enddate = enddate;
        this.budget = budget;
        this.projectManager = projectManager;
    }

    // Getters & Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public Employee getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(Employee projectManager) {
        this.projectManager = projectManager;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public LocalDate getEnddate() {
        return enddate;
    }

    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}