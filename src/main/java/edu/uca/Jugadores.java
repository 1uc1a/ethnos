package edu.uca;

import java.util.List;

public class Jugadores {
    List<Carta> mano;
    String nombre;
    int puntaje;
    int bandasJugadas;
    int fichasMapa;

    public Jugadores(List<Carta> mano, int puntaje, int bandasJugadas) {
        this.mano = mano;
        this.puntaje = puntaje;
        this.bandasJugadas = bandasJugadas;
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
        return "MazoJugador=" + mano;
    }
}
