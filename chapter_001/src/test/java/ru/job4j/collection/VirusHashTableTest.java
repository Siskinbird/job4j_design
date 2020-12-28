package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class VirusHashTableTest {
    @Test
    public void insert() {
       VirusHashTable<String, Hazard> virusHashTable = new VirusHashTable<>();
        assertTrue(virusHashTable.insert("COVID-19", new Hazard("You will definitely survive")));
        assertTrue(virusHashTable.insert("H1N1", new Hazard("You will survive")));
        assertTrue(virusHashTable.insert("HIV", new Hazard("You will die")));
        assertTrue(virusHashTable.insert("H7N9", new Hazard("You will die")));
        assertFalse(virusHashTable.insert("H1N1", new Hazard("You will survive")));
    }

    @Test
    public  void tryToGet() {
        VirusHashTable<String, Hazard> virusHashTable = new VirusHashTable<>();
        virusHashTable.insert("COVID-19", new Hazard("You will definitely survive"));
        virusHashTable.insert("H1N1", new Hazard("You will survive"));
        virusHashTable.insert("HIV", new Hazard("You will die"));
        assertThat(virusHashTable.get("H1N1"), is (new Hazard("You will survive")));

   }
   @Test
    public void tryToDelete() {
       VirusHashTable<String, Hazard> virusHashTable = new VirusHashTable<>();
       virusHashTable.insert("COVID-19", new Hazard("You will definitely survive"));
       virusHashTable.insert("H1N1", new Hazard("You will survive"));
       virusHashTable.insert("HIV", new Hazard("You will die"));
       assertTrue(virusHashTable.delete("H1N1"));
       assertTrue(virusHashTable.delete("COVID-19"));
       assertTrue(virusHashTable.delete("HIV"));
       assertFalse(virusHashTable.delete("KEKEREKE"));
   }


}
