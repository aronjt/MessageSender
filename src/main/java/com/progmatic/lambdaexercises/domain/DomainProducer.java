/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progmatic.lambdaexercises.domain;

import com.progmatic.lambdaexercises.domain.pet.PetOwner;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.progmatic.lambdaexercises.domain.indians.Indian;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author peti
 */
public class DomainProducer {

    private static List<PetOwner> petOwners = new ArrayList<>();
    private static List<Indian> indians = new ArrayList<>();
    private static boolean initiated = false;

    private static void init()  {
        if (!initiated) {
            try {
                InputStream is = Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("pets.json");
                ObjectMapper mapper = new ObjectMapper();
                petOwners  = mapper.readValue(is, mapper.getTypeFactory().constructCollectionType(List.class, PetOwner.class));
                
                InputStream is2 = Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("indians.json");
                indians = mapper.readValue(is2, mapper.getTypeFactory().constructCollectionType(List.class, Indian.class));
                
                initiated = true;
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static List<PetOwner> getPetOwners() {
        init();
        return petOwners;
    }

    public static List<Indian> getIndians() {
        init();
        return indians;
    }
    
    

    
}
