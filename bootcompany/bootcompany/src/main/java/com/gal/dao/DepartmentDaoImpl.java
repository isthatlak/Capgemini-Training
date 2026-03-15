package com.gal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gal.model.Department;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
    @Autowired
    EntityManagerFactory emf;
    public Department find(int depid) {
        EntityManager em=emf.createEntityManager();
        Department department=em.find(Department.class,depid);
        return department;
    }

    @Override
    public List<Department> findAll() {
        return List.of();
    }

    @Override
    public void add(Department department) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(department);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(int departmentId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Department department = em.find(Department.class, departmentId);
        if (department != null) {
            em.remove(department);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Department department) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(department);
        em.getTransaction().commit();
        em.close();
    }
}