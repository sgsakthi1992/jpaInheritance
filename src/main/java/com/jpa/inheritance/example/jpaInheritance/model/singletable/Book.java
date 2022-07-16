package com.jpa.inheritance.example.jpaInheritance.model.singletable;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("book")
public class Book extends Product {
    private String author;
}
