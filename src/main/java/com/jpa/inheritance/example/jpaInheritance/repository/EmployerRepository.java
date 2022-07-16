package com.jpa.inheritance.example.jpaInheritance.repository;

import com.jpa.inheritance.example.jpaInheritance.model.mappedsuperclass.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
