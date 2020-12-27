package ru.job4j.collection;

import java.util.Objects;

public class Viruses {
    private String since;
    private String hazardDegree;

    public Viruses(String since, String hazardDegree) {
        this.since = since;
        this.hazardDegree = hazardDegree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Viruses viruses = (Viruses) o;
        return Objects.equals(since, viruses.since) && Objects.equals(hazardDegree, viruses.hazardDegree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(since, hazardDegree);
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

    public String getHazardDegree() {
        return hazardDegree;
    }

    public void setHazardDegree(String hazardDegree) {
        this.hazardDegree = hazardDegree;
    }

    @Override
    public String toString() {
        return "Viruses{" +
                "name='" + since + '\'' +
                ", hazardDegree='" + hazardDegree + '\'' +
                '}';
    }
}
