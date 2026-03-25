package com.gal.dao;


import com.gal.EntityManagerFactoryConnectionMain;
import com.gal.model.Parking;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingDaoTest {

    @Test
    void testGetEmployee(){
        ParkingDao dao = new ParkingDao();
        Parking parking = dao.getParking(100);
        assertNull(parking);
    }

    @Test
    void testaddParking(){
        Parking obj = new Parking(1,"A001");
        ParkingDao dao = new ParkingDao();
        Parking parking = dao.addParking(obj);
        assertNotNull(parking);
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
