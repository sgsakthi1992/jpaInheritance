package com.jpa.inheritance.example.jpaInheritance.repository;

import com.jpa.inheritance.example.jpaInheritance.model.mappedsuperclass.Employee;
import com.jpa.inheritance.example.jpaInheritance.model.mappedsuperclass.Employer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class PersonRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @BeforeEach
    void setup() {
        var employee = new Employee();
        employee.setPersonId(1L);
        employee.setName("Employee 1");
        employee.setDepartment("IT");
        employeeRepository.save(employee);

        var employer = new Employer();
        employer.setPersonId(1L);
        employer.setName("Employer 1");
        employer.setCompanyName("EPAM");
        employerRepository.save(employer);
    }

    @Test
    void testEmployee() {
        var employees = employeeRepository.findAll();
        assertAll(
                () -> assertEquals(1, employees.size()),
                () -> assertEquals(1, employees.get(0).getPersonId()),
                () -> assertEquals("Employee 1", employees.get(0).getName()),
                () -> assertEquals("IT", employees.get(0).getDepartment())
        );
    }

    @Test
    void testEmployer() {
        var employers = employerRepository.findAll();
        assertAll(
                () -> assertEquals(1, employers.size()),
                () -> assertEquals(1, employers.get(0).getPersonId()),
                () -> assertEquals("Employer 1", employers.get(0).getName()),
                () -> assertEquals("EPAM", employers.get(0).getCompanyName())
        );
    }
}