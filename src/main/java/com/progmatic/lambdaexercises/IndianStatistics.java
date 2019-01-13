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
import java.util.List;
import java.util.Set;

/**
 *
 * @author peti
 */
public class IndianStatistics {

    private List<Indian> indians;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        IndianStatistics me = new IndianStatistics();
        me.indians = DomainProducer.getIndians();
        System.out.println("Ennyi különböző eszköz szerepel a leltárban: " + me.nrOfTools());
        System.out.println("Ezek a különböző eszközök szerepelnek a leltárban: " + me.diffTools());
        System.out.println("Az Apache törzs tagjainak száma: " + me.nrOfIndiansPerTribe("Apache"));
        System.out.println("A legnépesebb indián törzs: " + me.mostPopularTibe());
        me.nrOfIndiansPerTribe();
        System.out.println("A Seminole törzsben a ffi/nő arány: " + me.maleFemaleRatioPerTribe("Seminole"));
        System.out.println("A férfi-nő arány törzsenként:");
        me.maleFemaleRatio();
        String tribeWithMostTools = me.tribeWithMostTools("tomahawk");
        System.out.println("A legtöbb tomahawk-ja a " + tribeWithMostTools + " törzsnek van");

    }

    public int nrOfTools() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Set<String> diffTools() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int nrOfIndiansPerTribe(String tribe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void nrOfIndiansPerTribe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String mostPopularTibe() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double maleFemaleRatioPerTribe(String tribe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void maleFemaleRatio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String tribeWithMostTools(String tool) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
