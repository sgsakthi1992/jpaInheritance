package com.jpa.inheritance.example.jpaInheritance.model.mappedsuperclass;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Employer extends Person {
    private String companyName;
}
