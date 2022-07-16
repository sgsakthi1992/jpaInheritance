package com.jpa.inheritance.example.jpaInheritance.model.joined;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {
    @Id
    private Long animalId;
    private String species;
}
