package com.jpa.inheritance.example.jpaInheritance.model.singletable;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("pen")
public class Pen extends Product {
    private String color;
}
