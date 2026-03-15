package com.gal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gal.dao.DepartmentDao;
import com.gal.model.Department;
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentDao departmentDao;

    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public Department find(int departmentId) {
        return departmentDao.find(departmentId);
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public void add(Department department) {
        departmentDao.add(department);
    }

    @Override
    public void delete(int departmentId) {
        departmentDao.delete(departmentId);
    }

    @Override
    public void update(Department department) {
        departmentDao.update(department);
    }
}
