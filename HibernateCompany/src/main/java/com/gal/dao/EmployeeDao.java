package com.gal.dao;

import com.gal.EntityManagerFactoryConnectionMain;
import com.gal.model.Employee;
import jakarta.persistence.EntityManager;

public class EmployeeDao {
    public Employee getEmployee(int empid){
        EntityManager em = EntityManagerFactoryConnectionMain.getEntityManager();
        Employee employee = em.find(Employee.class, empid);
        return employee;
    }
}
