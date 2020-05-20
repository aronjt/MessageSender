package com.progmatic.lambdaexercises;

import com.progmatic.lambdaexercises.domain.DomainProducer;
import com.progmatic.lambdaexercises.domain.pet.Pet;
import com.progmatic.lambdaexercises.domain.pet.PetOwner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PetStatisticsTest {

    PetStatistics petStatistics;

    @BeforeEach
    void init(){
        petStatistics = new PetStatistics(DomainProducer.getPetOwners());
    }


    @Test
    void nrOfAllAnimals() {
        assertEquals(14, petStatistics.nrOfAllAnimals());
    }

    @Test
    void children() {
        List<PetOwner> children = petStatistics.children();
        assertEquals(2, children.size());
        assertEquals(1, children.stream().filter(petOwner -> petOwner.getName().equals("Remek Elek")).count());
        assertEquals(1, children.stream().filter(petOwner -> petOwner.getName().equals("Ultra Viola")).count());

    }

    @Test
    void nrOfFemaleOwners() {
        assertEquals(5, petStatistics.nrOfFemaleOwners());
    }

    @Test
    void childrenNames() {
        List<String> childrenNames = petStatistics.childrenNames();
        assertEquals(2, childrenNames.size());
        assertTrue(childrenNames.contains("Ultra Viola"));
        assertTrue(childrenNames.contains("Remek Elek"));
    }

    @Test
    void childrenUpperNames() {
        List<String> childrenNames = petStatistics.childrenUpperNames();
        assertEquals(2, childrenNames.size());
        assertTrue(childrenNames.contains("ULTRA VIOLA"));
        assertTrue(childrenNames.contains("REMEK ELEK"));
    }

    @Test
    void sumAgeOfOwners() {
        assertEquals(237, petStatistics.sumAgeOfOwners());
    }

    @Test
    void concatenatedNameOfPetOwners() {
    }

    @Test
    void allPets() {
        List<Pet> pets = petStatistics.allPets();
        assertEquals(14, pets.size());
    }

    @Test
    void peopleWhoHaveMoreAnimalsThan() {
        assertEquals(1, petStatistics.peopleWhoHaveMoreAnimalsThan(2).count());
        assertTrue(petStatistics.peopleWhoHaveMoreAnimalsThan(2).anyMatch(s -> s.equals("Ultra Viola")));

    }

    @Test
    void nrOfDistinctSpices() {
        assertEquals(11, petStatistics.nrOfDistinctSpices());
    }
}