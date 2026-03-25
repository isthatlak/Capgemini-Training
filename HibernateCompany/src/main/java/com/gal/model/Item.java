package com.gal.model;

import jakarta.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int itemid;
    String itemtype;
    String itemname;
    @Column(name = "cost", nullable = false)
    Double itemcost;

    public Item() {
    }

    public Item(int itemid, String itemtype, String itemname, Double itemcost ) {
        this.itemcost = itemcost;
        this.itemname = itemname;
        this.itemtype = itemtype;
        this.itemcost = itemcost;
    }

    public String getItemtype() {
        return itemtype;
    }

    public void setItemtype(String itemtype) {
        this.itemtype = itemtype;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public Double getItemcost() {
        return itemcost;
    }

    public void setItemcost(Double itemcost) {
        this.itemcost = itemcost;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemcost='" + itemcost + '\'' +
                ", itemid=" + itemid +
                ", itemtype='" + itemtype + '\'' +
                ", itemname='" + itemname + '\'' +
                '}';
    }
}
