package edu.uca;

public class Cartas {
    String tribu;
    String region;
    String color;

    public Cartas(String tribu, String region, String color) {
        this.tribu = tribu;
        this.region = region;
        this.color = color;
    }

    public Cartas(String tribu, String color) {
        this.tribu = tribu;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Carta{" + tribu + ", " + color + "}";
    }

}
