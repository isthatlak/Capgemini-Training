package com.gal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.gal.dao.DepartmentRepository;
import com.gal.model.Department;

import jakarta.transaction.Transactional;

@Service
@Primary
public class DepartmentServiceImpl2 implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department find(int departmentId) {

        Optional<Department> op = departmentRepository.findById(departmentId);

        return op.orElseThrow();   // return department or null
    }

    @Override
    public List<Department> findAll() {

        return departmentRepository.findAll();
    }

    @Override
    @Transactional
    public void add(Department department) {

        departmentRepository.save(department);
    }

    @Override
    @Transactional
    public void delete(int departmentId) {

        departmentRepository.deleteById(departmentId);
    }

    @Override
    @Transactional
    public void update(Department department) {

        departmentRepository.save(department);
    }
}
