package edu.uca;

import java.util.List;

public class Jugadores {
    List<Cartas> mano;
    int puntaje;
    int bandasJugadas;
    int fichasMapa;

    public Jugadores(List<Cartas> mano, int puntaje, int bandasJugadas, int fichasMapa) {
        this.mano = mano;
        this.puntaje = puntaje;
        this.bandasJugadas = bandasJugadas;
        this.fichasMapa = fichasMapa;
    }

    public void anadirCarta(Cartas carta) {
        mano.add(carta);
    }

    @Override
    public String toString() {
        return "MazoJugador=" + mano;
    }
}
