package com.gal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "parking")
public class Parking {


//    @SequenceGenerator(name="parkingSequence", initialValue = 201, allocationSize = 1, sequenceName = "parkingSequence")


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer parkingid;

    private int floorno;
    private String slotnumber;

    @OneToOne
    @JoinColumn(name = "empid", unique = true)
    private Employee employee;

    public Parking() {}

    public Parking(int floorno, String slotnumber, Employee employee) {
        this.floorno = floorno;
        this.slotnumber = slotnumber;
        this.employee = employee;
    }

    // Getters & Setters

    public String getSlotnumber() {
        return slotnumber;
    }

    public void setSlotnumber(String slotnumber) {
        this.slotnumber = slotnumber;
    }

    public Integer getParkingid() {
        return parkingid;
    }

    public void setParkingid(Integer parkingid) {
        this.parkingid = parkingid;
    }

    public int getFloorno() {
        return floorno;
    }

    public void setFloorno(int floorno) {
        this.floorno = floorno;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}