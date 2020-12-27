package ru.job4j.collection;

import org.junit.Test;

public class VirusHashMapTest {
    @Test
    public void insert(){
        VirusHashMap virusHashMap = new VirusHashMap();
        Viruses corona = new Viruses("2019", "Big Hazard");
        Viruses influence = new Viruses("1968", "Average Hazard");
        virusHashMap.insert("COVID-19",corona);
        virusHashMap.insert("H1N1", influence);
        //Assert.assertTrue(virusHashMap.insert("COVID-19", new Viruses("2019", "Big Hazard")));
        //        Assert.assertTrue(virusHashMap.insert("H1N1", new Viruses("1968", "Average Hazard")));
        //        Assert.assertTrue(virusHashMap.insert("COVID-19", new Viruses("2019", "Big Hazard")));
    }
}
