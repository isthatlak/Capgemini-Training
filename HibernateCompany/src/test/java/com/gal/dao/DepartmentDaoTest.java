package com.gal.dao;

import com.gal.EntityManagerFactoryConnectionMain;
import com.gal.model.Department;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentDaoTest {

    @Test
    void getDepartment(){
        DepartmentDao dao = new DepartmentDao();
        Department department = dao.getDepartment(10);

        assertNotNull(department);
        System.out.println(department);
        assertEquals("Administration",department.getDepartmentName());
    }


    @BeforeAll
    public static void openConnection(){
        System.out.println("Opening Connections");
        EntityManagerFactoryConnectionMain.getEntityManager();
    }

    @AfterAll
    public static void closeConnection(){
        System.out.println("Closing Connections");
        EntityManagerFactoryConnectionMain.getEntityManager().close();
        EntityManagerFactoryConnectionMain.getEntityManagerFactory().close();
    }
}