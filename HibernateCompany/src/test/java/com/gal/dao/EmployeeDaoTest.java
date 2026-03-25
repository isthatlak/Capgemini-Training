package com.gal.dao;


import com.gal.EntityManagerFactoryConnectionMain;
import com.gal.model.Employee;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeDaoTest {

    @Test
    void testGetEmployee(){
        EmployeeDao dao = new EmployeeDao();
        Employee employee = dao.getEmployee(100);
        assertNotNull(employee);
        System.out.println(employee);
        assertEquals("Steven",employee.getFirstName());
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
