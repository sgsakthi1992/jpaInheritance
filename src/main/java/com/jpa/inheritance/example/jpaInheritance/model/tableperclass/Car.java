package com.jpa.inheritance.example.jpaInheritance.model.tableperclass;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicle {
    private String seatBelt;
}
