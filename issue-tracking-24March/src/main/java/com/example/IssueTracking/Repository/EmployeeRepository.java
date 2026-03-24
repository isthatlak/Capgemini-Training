package com.example.IssueTracking.Repository;

import com.example.IssueTracking.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}