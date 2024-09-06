package edu.uca;


public class Region {
    private int puntaje1;
    private int puntaje2;
    private int puntaje3;
    private String nombre;
    private String color;

    public Region(int puntaje1,int puntaje2, int puntaje3, String nombre, String color) {
        this.puntaje1 = puntaje1;
        this.puntaje2 = puntaje2;
        this.puntaje3 = puntaje3;
        this.nombre = nombre;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Region{puntaje1=" + puntaje1 + ", puntaje2='" + puntaje2 + "', puntaje3=" + puntaje3 + "}";
    }
}
