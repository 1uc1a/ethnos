package edu.uca;

import java.util.List;

public class Jugadores {
    List<Carta> mano;
    int puntaje;
    int bandasJugadas;
    int fichasMapa;

    public Jugadores(List<Carta> mano, int puntaje, int bandasJugadas, int fichasMapa) {
        this.mano = mano;
        this.puntaje = puntaje;
        this.bandasJugadas = bandasJugadas;
        this.fichasMapa = fichasMapa;
    }

    public void anadirCarta(Carta carta) {
        mano.add(carta);
    }

    public List<Carta> getCartas(){
        return mano;
    }

    @Override
    public String toString() {
        return "MazoJugador=" + mano;
    }
}
