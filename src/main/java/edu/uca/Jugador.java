package edu.uca;

import java.util.List;

public class Jugador {
    List<Carta> mano;
    int puntaje;
    int bandasJugadas;
    int fichasMapa;
    String nombre;

    public Jugador(List<Carta> mano, int puntaje, int bandasJugadas, int fichasMapa, String nombre) {
        this.mano = mano;
        this.puntaje = puntaje;
        this.bandasJugadas = bandasJugadas;
        this.fichasMapa = fichasMapa;
        this.nombre = nombre;
    }

    public void anadirCarta(Carta carta) {
        mano.add(carta);
    }

    public List<Carta> getCartas(){
        return mano;
    }
    public String getNombre() {
        return nombre;
    }
    @Override
    public String toString() {
        return nombre + " - Mano=" + mano + " - Puntaje: " + puntaje;
    }
}
