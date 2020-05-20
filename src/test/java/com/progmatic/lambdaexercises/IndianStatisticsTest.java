package com.progmatic.lambdaexercises;

import com.progmatic.lambdaexercises.domain.DomainProducer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class IndianStatisticsTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    IndianStatistics indianStatistics;

    @BeforeEach
    public void setUp(){
        indianStatistics = new IndianStatistics(DomainProducer.getIndians());
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @org.junit.jupiter.api.Test
    void nrOfTools() {
        int nrOfTools = indianStatistics.nrOfTools();
        assertEquals(61, nrOfTools);
    }

    @org.junit.jupiter.api.Test
    void diffTools() {
        Set<String> tools = indianStatistics.diffTools();
        assertEquals(7, tools.size());
        assertTrue(tools.contains("békepipa"));
        assertTrue(tools.contains("mokaszin"));
        assertTrue(tools.contains("puska"));
        assertTrue(tools.contains("dob"));
        assertTrue(tools.contains("tűzszerszám"));
        assertTrue(tools.contains("íj"));
        assertTrue(tools.contains("tomahawk"));


    }

    @org.junit.jupiter.api.Test
    void nrOfIndiansPerTribe() {
        int apaches = indianStatistics.nrOfIndiansPerTribe("Apache");
        assertEquals(6, apaches);

        int hurons = indianStatistics.nrOfIndiansPerTribe("Huron");
        assertEquals(5, hurons);

        int none = indianStatistics.nrOfIndiansPerTribe("none");
        assertEquals(0, none);
    }

    @org.junit.jupiter.api.Test
    void testNrOfIndiansPerTribe() {
        indianStatistics.nrOfIndiansPerTribe();

        String out = outContent.toString();
        String[] rows = out.split("\n");
        assertEquals(5, rows.length);
        assertArrayContains(rows, "Huron: 5");
        assertArrayContains(rows, "Iroquois: 3");
        assertArrayContains(rows, "Seminole: 4");
        assertArrayContains(rows, "Apache: 6");
        assertArrayContains(rows, "Sioux: 7");
    }

    private void assertArrayContains(String[] rows, String s) {
        for (String row : rows) {
            if(row.equals(s)){
                return;
            }

        }
        fail("Array does not contain: " + s);
    }


    @org.junit.jupiter.api.Test
    void mostPopularTibe() {
        String mostPopularTibe = indianStatistics.mostPopularTibe();
        assertEquals("Sioux", mostPopularTibe);
    }

    @org.junit.jupiter.api.Test
    void maleFemaleRatioPerTribe() {
        double ratio = indianStatistics.maleFemaleRatioPerTribe("Seminole");
        assertEquals(3, ratio, 0.01);

        ratio = indianStatistics.maleFemaleRatioPerTribe("Iroquois");
        assertEquals(-1, ratio, 0);

        ratio = indianStatistics.maleFemaleRatioPerTribe("Apache");
        assertEquals(2, ratio, 0.01);

        ratio = indianStatistics.maleFemaleRatioPerTribe("Sioux");
        assertEquals(0.75, ratio, 0.01);
    }

    @org.junit.jupiter.api.Test
    void maleFemaleRatio() {
        indianStatistics.maleFemaleRatio();
        String out = outContent.toString();
        String[] rows = out.split("\n");
        assertEquals(5, rows.length);
        assertArrayContains(rows, "Iroquois törzsben a ffi/nő arány: -1.0");
        assertArrayContains(rows, "Seminole törzsben a ffi/nő arány: 3.0");
        assertArrayContains(rows, "Apache törzsben a ffi/nő arány: 2.0");
    }

    @org.junit.jupiter.api.Test
    void tribeWithMostTools() {
        String tribeWithMostTools = indianStatistics.tribeWithMostTools("tomahawk");
        assertEquals("Sioux", tribeWithMostTools);
    }
}