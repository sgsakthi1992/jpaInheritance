package com.jpa.inheritance.example.jpaInheritance.model.tableperclass;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Bike extends Vehicle {
    private String helmet;
}
