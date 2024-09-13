package edu.uca;

public class Carta {
    String tribu;
    String region;
    String color;

    public Carta(String tribu, String region, String color) {
        this.tribu = tribu;
        this.region = region;
        this.color = color;
    }

    public Carta(String tribu, String color) {
        this.tribu = tribu;
        this.color = color;
    }

    @Override
    public String toString() {
        return "[" + tribu + ", " + color + "]";
    }

}
