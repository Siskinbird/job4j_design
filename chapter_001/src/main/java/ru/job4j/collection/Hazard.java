package ru.job4j.collection;

import java.util.Objects;

public class Hazard {
    private final String hazardRate;

    Hazard(final String hazardRate) {
        this.hazardRate = hazardRate;
    }

    public String getHazardRate() {
        return hazardRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hazard hazard = (Hazard) o;
        return Objects.equals(hazardRate, hazard.hazardRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hazardRate);
    }

    @Override
    public String toString() {
        return "Hazard{" +
                "hazardRate='" + hazardRate + '\'' +
                '}';
    }
}
