/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progmatic.lambdaexercises;

import com.progmatic.lambdaexercises.domain.DomainProducer;
import com.progmatic.lambdaexercises.domain.pet.Pet;
import com.progmatic.lambdaexercises.domain.pet.PetOwner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author peti
 */
public class PetStatistics {

    private List<PetOwner> petOwners;

    public PetStatistics(List<PetOwner> petOwners) {
        this.petOwners = petOwners;
    }

    public static void main(String[] args) {
        PetStatistics me = new PetStatistics(DomainProducer.getPetOwners());

        System.out.println("Number of all animals:" + me.nrOfAllAnimals());

        System.out.println("Children:");
        me.children().stream().forEach(c -> System.out.println(c));

        System.out.println("Children names:");
        me.childrenNames().stream().forEach(name -> System.out.println(name));

        System.out.println("Children upper names:");
        me.childrenUpperNames().stream().forEach(name -> System.out.println(name));

        System.out.println("\nHölgygazdák száma:" + me.nrOfFemaleOwners());
        System.out.println("Sum age of owners: " + me.sumAgeOfOwners());
        System.out.println("Number of all animals:" + me.nrOfAllAnimals());
        Stream<String> peopleWhoHaveMoreAnimalsThan = me.peopleWhoHaveMoreAnimalsThan(2);
        System.out.println("People who have more animals than 2:");
        peopleWhoHaveMoreAnimalsThan.forEach(name -> System.out.println(name));
        System.out.println("\n\nNumber of distinct species: " + me.nrOfDistinctSpices());
        System.out.println("\n\n concatenated name of pet owners: " + me.concatenatedNameOfPetOwners());

    }


    public int nrOfAllAnimals() {
        throw  new UnsupportedOperationException();
    }

    /**
     *
     * @return all the PetOwners who are under 18
     */
    public List<PetOwner> children() {
        throw  new UnsupportedOperationException();
    }

    public long nrOfFemaleOwners() {
        throw  new UnsupportedOperationException();
    }

    /**
     *
     * @return all the names of the PetOwners who are under 18
     */
    public List<String> childrenNames() {
        throw  new UnsupportedOperationException();
    }

    /**
     *
     * @return all the names (in uppercase format) of the PetOwners who are
     * under 18
     */
    public List<String> childrenUpperNames() {
        throw  new UnsupportedOperationException();
    }

    public int sumAgeOfOwners() {
        throw  new UnsupportedOperationException();
    }

    public String concatenatedNameOfPetOwners() {
        throw  new UnsupportedOperationException();
    }

    public List<Pet> allPets() {
        throw  new UnsupportedOperationException();
    }

    public Stream<String> peopleWhoHaveMoreAnimalsThan(int nrOfAnimals) {
        throw  new UnsupportedOperationException();
    }

    public int nrOfDistinctSpices() {
        throw  new UnsupportedOperationException();
    }

}
