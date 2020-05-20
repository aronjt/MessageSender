/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progmatic.lambdaexercises;

import com.progmatic.lambdaexercises.domain.DomainProducer;
import com.progmatic.lambdaexercises.domain.indians.Indian;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author peti
 */
public class IndianStatistics {

    private List<Indian> indians;

    public IndianStatistics(List<Indian> indians) {
        this.indians = indians;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        IndianStatistics me = new IndianStatistics(DomainProducer.getIndians());
        System.out.println("Ennyi eszköz szerepel a leltárban: " + me.nrOfTools());
        System.out.println("Ezek a különböző eszközök szerepelnek a leltárban: " + me.diffTools());
        String tribe = "Apache";
        System.out.println("Az " + tribe + " törzs tagjainak száma: " + me.nrOfIndiansPerTribe(tribe));
        me.nrOfIndiansPerTribe();
        System.out.println("A legnépesebb indián törzs: " + me.mostPopularTibe());
        System.out.println("A Seminole törzsben a ffi/nő arány: " + me.maleFemaleRatioPerTribe("Seminole"));
        System.out.println("A férfi-nő arány törzsenként:");
        me.maleFemaleRatio();
        String tribeWithMostTools = me.tribeWithMostTools("tomahawk");
        System.out.println("A legtöbb tomahawk-ja a " + tribeWithMostTools + " törzsnek van");

    }

    public int nrOfTools() {
        throw new UnsupportedOperationException();
    }

    public Set<String> diffTools() {
        throw new UnsupportedOperationException();
    }

    public int nrOfIndiansPerTribe(String tribe) {
        throw new UnsupportedOperationException();
    }

    /**
     * Write number of indians for each tribe to the system out.
     * Every new tribe should be printed as a new line, and every line should contain
     * tribename ': ' nrOfIndians
     * E.g.
     * Huron: 6
     * Apache: 2
     * Seminole: 4
     */
    public void nrOfIndiansPerTribe() {
        throw new UnsupportedOperationException();
    }

    public String mostPopularTibe() {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param tribe
     * @return the ratio of male / female, or -1 if there are no female indians in this tribe!
     */
    public double maleFemaleRatioPerTribe(String tribe) {
        throw new UnsupportedOperationException();
    }

    /**
     * Write male/female ratio for each tribe to the system out.
     * Every new ratio should be printed as a new line, and every line should contain
     *  {tribename} törzsben a ffi/nő arány: {ratio}
     * E.g.
     * Iroquois törzsben a ffi/nő arány: -1.0
     * Seminole törzsben a ffi/nő arány: 3.0
     */
    public void maleFemaleRatio() {
        throw new UnsupportedOperationException();
    }

    public String tribeWithMostTools(String tool) {
        throw new UnsupportedOperationException();
    }

}
