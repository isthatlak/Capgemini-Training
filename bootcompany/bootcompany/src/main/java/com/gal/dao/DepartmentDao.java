package com.gal.dao;

import com.gal.model.Department;

import java.util.List;

public interface  DepartmentDao {
    Department find(int depid);

    List<Department> findAll();

    void add(Department department);

    void delete(int departmentId);

    void update(Department department);
}
