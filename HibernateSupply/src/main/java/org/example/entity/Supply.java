package org.example.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Supply")
public class Supply {

    @Id
    private int billno;

    @ManyToOne
    @JoinColumn(name="sid")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name="itemid")
    private Item item;

    private Date datesupply;

    private int price;

    private int qty;

    public Supply(){}

    public int getBillno() {
        return billno;
    }

    public void setBillno(int billno) {
        this.billno = billno;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Date getDatesupply() {
        return datesupply;
    }

    public void setDatesupply(Date datesupply) {
        this.datesupply = datesupply;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
