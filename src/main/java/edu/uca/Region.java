package edu.uca;


public class Region {
    private int puntaje1;
    private int puntaje2;
    private int puntaje3;
    private String nombre;
    private String color;

    public Region(String nombre, String color, int puntaje1,int puntaje2) {
        this.nombre = nombre;
        this.color = color;
        this.puntaje1 = puntaje1;
        this.puntaje2 = puntaje2;
    }

    public Region(String nombre, String color, int puntaje1,int puntaje2, int puntaje3) {
        this.nombre = nombre;
        this.color = color;
        this.puntaje1 = puntaje1;
        this.puntaje2 = puntaje2;
        this.puntaje3 = puntaje3;
    }

    private void ordenarPuntos(){
        //TODO asegurarse que puntaje1 sea menor a puntaje 2 (y estos a puntaje 3 si es que existe
    }

    @Override
    public String toString() {
        return "Region{" + "Nombre: " + nombre + "puntaje1=" + puntaje1 + ", puntaje2='" + puntaje2 + "', puntaje3=" + puntaje3 + "}";
    }

    public void setPuntaje1(int puntaje1) {
        this.puntaje1 = puntaje1;
    }

    public void setPuntaje2(int puntaje2) {
        this.puntaje2 = puntaje2;
    }

    public void setPuntaje3(int puntaje3) {
        this.puntaje3 = puntaje3;
    }
}
