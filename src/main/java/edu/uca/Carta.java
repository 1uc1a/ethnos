package edu.uca;

public class Carta {
    Tribu tribu;
    Color color;

    public Carta(Tribu tribu, Color color) {
        this.tribu = tribu;
        this.color = color;
    }

    public Tribu getTribu() {
        return tribu;
    }

    public String getColor() {
        return String.valueOf(color);
    }

    @Override
    public String toString() {
        return "[" + tribu + ", " + color + "]";
    }

}
