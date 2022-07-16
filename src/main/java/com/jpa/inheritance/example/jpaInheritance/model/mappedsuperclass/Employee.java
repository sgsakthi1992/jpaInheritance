package com.jpa.inheritance.example.jpaInheritance.model.mappedsuperclass;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Employee extends Person {
    private String department;
}
