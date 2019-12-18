/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progmatic.lambdaexercises;

import com.progmatic.lambdaexercises.domain.DomainProducer;
import com.progmatic.lambdaexercises.domain.pet.PetOwner;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author peti
 */
public class PetStatistics {
    
    private List<PetOwner> petOwners;
    
    public static void main(String[] args) {
        PetStatistics me = new PetStatistics();
        me.petOwners = DomainProducer.getPetOwners();
        System.out.println("Number of all animals:" + me.nrOfAllAnimals());

        System.out.println("Children:");
        me.children().stream().forEach(c -> System.out.println(c));

        System.out.println("Children names:");
        me.childrenNames().stream().forEach(name -> System.out.println(name));

        System.out.println("Children upper names:");
        me.childrenUpperNames().stream().forEach(name -> System.out.println(name));

        System.out.println("sum age of owners: " + me.sumAgeOfOwners());

        Stream<String> peopleWhoHaveMoreAnimalsThan = me.peopleWhoHaveMoreAnimalsThan(2);
        System.out.println("People who have more animals than 2:");
        peopleWhoHaveMoreAnimalsThan.forEach(name -> System.out.println(name));
        
        System.out.println("Number of distinct species: " + me.nrOfDistinctSpices());
    }
    
    public int nrOfAllAnimals(){
        return 0;
    }
    
    /**
     * 
     * @return all the PetOwners who are under 18
     */
    public List<PetOwner> children(){
        return null;
    }
    
    /**
     * 
     * @return all the names of the PetOwners who are under 18
     */
    public List<String> childrenNames(){
        return null;
    }
    
    /**
     * 
     * @return all the names (in uppercase format) of the PetOwners who are under 18
     */
    public List<String> childrenUpperNames(){
        return null;
    }
    
    public int sumAgeOfOwners(){
        return 0;
    }
    
    public Stream<String> peopleWhoHaveMoreAnimalsThan(int nrOfAnimals){
        return null;
    }
    
    public int nrOfDistinctSpices(){
        return 0;
    }
    
}
