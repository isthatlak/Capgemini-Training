package com.gal.dao;

import com.gal.EntityManagerFactoryConnectionMain;
import com.gal.model.Department;
import com.gal.model.Parking;
import jakarta.persistence.EntityManager;

public class DepartmentDao {
    public Department getDepartment(int deptid){
        EntityManager em = EntityManagerFactoryConnectionMain.getEntityManager();
        Department department = em.find(Department.class, deptid);
        return department;
    }

    public Department addDepartment(Department department){
        EntityManager em = EntityManagerFactoryConnectionMain.getEntityManager();
        em.getTransaction().begin();
        em.persist(department);//automatically creates connection, preparedStatement, fill up, executeupdate, create queries
        em.getTransaction().commit();
        return department;
    }
}
