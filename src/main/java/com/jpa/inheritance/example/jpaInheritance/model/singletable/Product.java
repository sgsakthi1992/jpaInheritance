package com.jpa.inheritance.example.jpaInheritance.model.singletable;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type", discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorFormula("case when author is not null then book else pen end")
public class Product {

    @Id
    private Long productId;
    private String name;
    @Column(name = "product_type", insertable = false, updatable = false)
    private String productType;

}
