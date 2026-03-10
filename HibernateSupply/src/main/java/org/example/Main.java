package org.example;

import org.example.entity.*;
import javax.persistence.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("messPU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Create Suppliers
        Supplier s1 = new Supplier();
        s1.setSid(1);
        s1.setSname("Rajan enterprises");
        s1.setSrank(4.5);
        s1.setCity("Delhi");

        Supplier s2 = new Supplier();
        s2.setSid(2);
        s2.setSname("Indian supply");
        s2.setSrank(3.4);
        s2.setCity("Gurugram");

        em.persist(s1);
        em.persist(s2);

        // Create Items
        Item i1 = new Item();
        i1.setItemid(1);
        i1.setName("Tomato");
        i1.setType("Veg");

        Item i2 = new Item();
        i2.setItemid(2);
        i2.setName("Onion");
        i2.setType("Veg");

        Item i3 = new Item();
        i3.setItemid(3);
        i3.setName("Sugar");
        i3.setType("Groc");

        em.persist(i1);
        em.persist(i2);
        em.persist(i3);

        // Create Supply records
        Supply sp1 = new Supply();
        sp1.setBillno(1);
        sp1.setSupplier(s1);
        sp1.setItem(i2);
        sp1.setPrice(36);
        sp1.setQty(50);

        Supply sp2 = new Supply();
        sp2.setBillno(2);
        sp2.setSupplier(s1);
        sp2.setItem(i3);
        sp2.setPrice(10);
        sp2.setQty(45);

        Supply sp3 = new Supply();
        sp3.setBillno(3);
        sp3.setSupplier(s2);
        sp3.setItem(i1);
        sp3.setPrice(50);
        sp3.setQty(10);

        em.persist(sp1);
        em.persist(sp2);
        em.persist(sp3);

        em.getTransaction().commit();

        // Query 1
        List<String> suppliers =
                em.createQuery("select s.sname from Supplier s", String.class)
                        .getResultList();

        System.out.println("Supplier Names:");
        suppliers.forEach(System.out::println);

        // Query 2
        List<String> delhiSuppliers =
                em.createQuery("select s.sname from Supplier s where s.city='Delhi'", String.class)
                        .getResultList();

        System.out.println("\nSuppliers from Delhi:");
        delhiSuppliers.forEach(System.out::println);

        // Query 3
        List<String> items =
                em.createQuery("select sp.item.name from Supply sp where sp.supplier.sid=1", String.class)
                        .getResultList();

        System.out.println("\nItems supplied by supplier 1:");
        items.forEach(System.out::println);

        em.close();
        emf.close();
    }
}