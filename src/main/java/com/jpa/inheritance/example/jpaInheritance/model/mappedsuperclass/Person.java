package com.jpa.inheritance.example.jpaInheritance.model.mappedsuperclass;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public class Person {
    @Id
    private Long personId;
    private String name;
}
