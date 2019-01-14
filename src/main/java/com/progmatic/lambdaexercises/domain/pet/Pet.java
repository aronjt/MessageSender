/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progmatic.lambdaexercises.domain.pet;

/**
 *
 * @author peti
 */
public class Pet {
    private String name;
    private int age;
    private String spices;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpices() {
        return spices;
    }

    public void setSpices(String spices) {
        this.spices = spices;
    }

    @Override
    public String toString() {
        return "Pet{" + "name=" + name + ", age=" + age + ", spices=" + spices + '}';
    }
    
    
}
