package edu.uca;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bandas {
    private List<List<Cartas>> bandasJugadas;

    public Bandas() {
        this.bandasJugadas = new ArrayList<>();
    }

    // Método para formar una banda de cartas con el mismo personaje o color
    public boolean formarBanda(List<Cartas> cartasJugador, Cartas nuevaCarta) {
        List<Cartas> banda = new ArrayList<>();
        banda.add(nuevaCarta);

        // Revisar si las cartas del jugador tienen el mismo personaje o color que la nueva carta
        for (Cartas carta : cartasJugador) {
            if (carta.tribu.equals(nuevaCarta.tribu) || carta.color.equals(nuevaCarta.color)) {
                banda.add(carta);
            }
        }

        // Si se puede formar una banda válida (al menos dos cartas), se añade a las bandas jugadas
        if (banda.size() > 1) {
            bandasJugadas.add(banda);
            cartasJugador.removeAll(banda); // Eliminar cartas de la mano del jugador
            return true; // Banda formada exitosamente
        }

        return false; // No se pudo formar una banda
    }

    // Método para obtener todas las posibles bandas que se pueden formar
    public List<List<Cartas>> obtenerBandasPosibles(List<Cartas> cartasJugador) {
        List<List<Cartas>> posiblesBandas = new ArrayList<>();
        Set<String> procesadas = new HashSet<>();

        // Agrupar cartas por tribu (personaje)
        for (Cartas carta : cartasJugador) {
            if (!procesadas.contains(carta.tribu)) {
                List<Cartas> bandaPorTribu = new ArrayList<>();
                for (Cartas otraCarta : cartasJugador) {
                    if (otraCarta.tribu.equals(carta.tribu)) {
                        bandaPorTribu.add(otraCarta);
                    }
                }
                if (bandaPorTribu.size() > 1) {
                    posiblesBandas.add(bandaPorTribu);
                }
                procesadas.add(carta.tribu);
            }
        }

        procesadas.clear();

        // Agrupar cartas por color
        for (Cartas carta : cartasJugador) {
            if (!procesadas.contains(carta.color)) {
                List<Cartas> bandaPorColor = new ArrayList<>();
                for (Cartas otraCarta : cartasJugador) {
                    if (otraCarta.color.equals(carta.color)) {
                        bandaPorColor.add(otraCarta);
                    }
                }
                if (bandaPorColor.size() > 1) {
                    posiblesBandas.add(bandaPorColor);
                }
                procesadas.add(carta.color);
            }
        }

        return posiblesBandas;
    }

    // Obtener todas las bandas jugadas
    public List<List<Cartas>> getBandasJugadas() {
        return bandasJugadas;
    }

    @Override
    public String toString() {
        return "Bandas jugadas: " + bandasJugadas;
    }
}

