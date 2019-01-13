/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progmatic.lambdaexercises.domain.indians;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author peti
 */
public class Indian implements Comparable<Indian> {

    private  String name;
    private  int age;
    private  String tribe;
    private  boolean isFemale;
    private  List<String> posessions = new ArrayList<>();

 

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTribe() {
        return tribe;
    }

    public boolean isIsFemale() {
        return isFemale;
    }

    public List<String> getPosessions() {
        return posessions;
    }

    @Override
    public String toString() {
        return "Indian{" + "name=" + name + ", age=" + age + ", tribe=" + tribe + ", isFemale=" + isFemale + ", posessions=" + posessions + '}';
    }

    @Override
    public int compareTo(Indian indian) {
        if (this.age == indian.age) {
            return this.name.compareTo(indian.name);

        }
        return this.age-indian.age;

    }

}
