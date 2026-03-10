package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name="Supplier")
public class Supplier {

    @Id
    private int sid;

    private String sname;

    private double srank;

    private String city;

    public Supplier(){}

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public double getSrank() {
        return srank;
    }

    public void setSrank(double srank) {
        this.srank = srank;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
