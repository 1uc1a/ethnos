package edu.uca;

public class Carta {
    Tribu tribu;
    String region;
    Color color;

    public Carta(Tribu tribu, Color color) {
        this.tribu = tribu;
        this.color = color;
    }

    @Override
    public String toString() {
        return "[" + tribu + ", " + color + "]";
    }

}
