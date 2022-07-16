package com.jpa.inheritance.example.jpaInheritance.repository;

import com.jpa.inheritance.example.jpaInheritance.model.joined.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
