package com.gal.service;

import java.util.List;
import com.gal.model.Department;

public interface DepartmentService {

    Department find(int departmentId);

    List<Department> findAll();
    void add(Department department);
    void delete(int departmentId);
    void update(Department department);

}
