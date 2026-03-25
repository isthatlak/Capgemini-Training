package com.gal.dao;

import com.gal.EntityManagerFactoryConnectionMain;
import com.gal.model.Parking;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class ParkingDao {
    public Parking getParking(int parkingid){
        EntityManager em = EntityManagerFactoryConnectionMain.getEntityManager();
        Parking parking = em.find(Parking.class, parkingid);
        return parking;
    }
    public Parking addParking(Parking parking){
        EntityManager em = EntityManagerFactoryConnectionMain.getEntityManager();
        em.getTransaction().begin();
        em.persist(parking);//automatically creates connection, preparedStatement, fill up, executeupdate, create queries
        em.getTransaction().commit();
        return parking;
    }
}
