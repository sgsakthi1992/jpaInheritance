package com.jpa.inheritance.example.jpaInheritance.repository;

import com.jpa.inheritance.example.jpaInheritance.model.singletable.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository<T extends Product> extends JpaRepository<T, Long> {
    List<T> findByProductType(String type);
}
