package ru.job4j.collection;


import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class HazardTableTest {

    @Test
    public void insert() {
        HazardTable<String, String> hazardTable = new HazardTable<>();
        assertTrue(hazardTable.insert("COVID-19", "You will definitely survive"));
        assertTrue(hazardTable.insert("H1N1", "You will survive"));
        assertTrue(hazardTable.insert("HIV", "You will survive"));
        assertTrue(hazardTable.insert("TESTTEST", "You will die"));
        assertTrue(hazardTable.insert("COVID-18", "You will definitely survive"));
        assertFalse(hazardTable.insert("H1N1", "You will survive"));
    }

    @Test
    public  void tryToGet() {
        HazardTable<String, String> hazardTable = new HazardTable<>();
        hazardTable.insert("COVID-19", "You will definitely survive");
        hazardTable.insert("H1N1", "You will survive");
        hazardTable.insert("HIV", "You will die");
        assertThat(hazardTable.get("H1N1"), is("You will survive"));

    }

    @Test
    public  void tryToGetNull() {
        HazardTable<String, String> hazardTable = new HazardTable<>();
        hazardTable.insert("COVID-19", "You will definitely survive");
        hazardTable.insert("H1N1", "You will survive");
        hazardTable.insert("HIV", "You will die");
        assertNull(hazardTable.get("NULL"));

    }

    @Test
        public void tryToDelete() {
            HazardTable<String, String> hazardTable = new HazardTable<>();
            hazardTable.insert("COVID-19", "You will definitely survive");
            hazardTable.insert("H1N1", "You will survive");
            hazardTable.insert("HIV", "You will die");
            assertTrue(hazardTable.delete("COVID-19"));
            assertTrue(hazardTable.delete("HIV"));
            assertTrue(hazardTable.delete("H1N1"));
            assertFalse(hazardTable.delete("KEKEREKE"));
        }

     @Test
        public void iteratorNext() {
        HazardTable<String, String> hazardTable = new HazardTable<>();
        hazardTable.insert("COVID-19", "You will definitely survive");
        hazardTable.insert("H1N1", "You will survive");
        hazardTable.insert("HIV", "You will die");
        hazardTable.insert("TESTTEST", "You will die");
        hazardTable.insert("COVID-18", "You will definitely survive");
        Iterator<String> it = hazardTable.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("H1N1"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("COVID-19"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("TESTTEST"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("COVID-18"));
    }

    @Test(expected = NoSuchElementException.class)
    public void noSuchElement() {
        HazardTable<String, String> hazardTable = new HazardTable<>();
        hazardTable.insert("COVID-19", "You will definitely survive");
        Iterator<String> it = hazardTable.iterator();
        it.next();
        it.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void modificationError() {
        HazardTable<String, String> hazardTable = new HazardTable<>();
        hazardTable.insert("COVID-19", "You will definitely survive");
        Iterator<String> it = hazardTable.iterator();
        hazardTable.insert("H1N1", "You will survive");
        it.next();
        it.next();

    }
}
