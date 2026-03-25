package com.gal.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

public class Quotation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int qid;
    Date qdate;
    Double cost;
}
