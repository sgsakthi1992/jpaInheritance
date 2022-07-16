package com.jpa.inheritance.example.jpaInheritance.repository;

import com.jpa.inheritance.example.jpaInheritance.model.joined.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class AnimalPetRepositoryTest {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private PetRepository petRepository;

    @BeforeEach
    void setup() {
        var pet = new Pet();
        pet.setAnimalId(1L);
        pet.setSpecies("Dog");
        pet.setName("Bull dog");
        petRepository.save(pet);
    }

    @Test
    void testAnimal() {
        var animal = animalRepository.findById(1L);
        assertEquals("Dog", animal.get().getSpecies());
    }

    @Test
    void testPet() {
        var pet = petRepository.findById(1L);
        assertEquals("Bull dog", pet.get().getName());
    }
}