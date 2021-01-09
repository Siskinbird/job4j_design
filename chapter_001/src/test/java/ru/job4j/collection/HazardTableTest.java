package ru.job4j.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class HazardTableTest {
    @Before
    public void initTable() {
        HazardTable<String, String> hazardTable = new HazardTable<>();
    }

    @Test
    public void insert() {
        HazardTable<String, String> hazardTable = new HazardTable<>();
        assertTrue(hazardTable.insert("COVID-19", "You will definitely survive"));
        assertTrue(hazardTable.insert("H1N1", "You will survive"));
        assertTrue(hazardTable.insert("HIV", "You will die"));
        assertTrue(hazardTable.insert("H7N9", "You will die"));
        assertTrue(hazardTable.insert("COVID-18", "You will definitely survive"));
        assertFalse(hazardTable.insert("H1N1", "You will survive"));
    }
    @Test
    public  void tryToGet() {
        HazardTable<String, String> hazardTable = new HazardTable<>();
        hazardTable.insert("COVID-19", "You will definitely survive");
        hazardTable.insert("H1N1", "You will survive");
        hazardTable.insert("HIV", "You will die");
        assertThat(hazardTable.get("H1N1"), is ("You will survive"));

    }
    @Test
    public void tryToDelete() {
        HazardTable<String, String> hazardTable = new HazardTable<>();
        hazardTable.insert("COVID-19", "You will definitely survive");
        hazardTable.insert("H1N1","You will survive");
        hazardTable.insert("HIV", "You will die");
        assertTrue(hazardTable.delete("H1N1"));
        assertTrue(hazardTable.delete("COVID-19"));
        assertTrue(hazardTable.delete("HIV"));
        assertFalse(hazardTable.delete("KEKEREKE"));
    }
    @Test
    public void iterator(){
        HazardTable<String, String> hazardTable = new HazardTable<>();
        Iterator<String> hazIt = hazardTable.iterator();
        hazardTable.insert("COVID-19", "You will definitely survive");
        assertTrue(hazIt.hasNext());
        hazIt.next();
        assertFalse(hazIt.hasNext());
    }

}
