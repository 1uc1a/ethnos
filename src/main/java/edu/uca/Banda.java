package edu.uca;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Banda {
    private List<List<Carta>> bandasJugadas;

    public Banda() {
        this.bandasJugadas = new ArrayList<>();
    }

    public boolean formarBanda(List<Carta> cartaJugador, Carta nuevaCarta) {
        List<Carta> banda = new ArrayList<>();
        banda.add(nuevaCarta);

        for (Carta carta : cartaJugador) {
            if (carta != nuevaCarta && (carta.tribu.equals(nuevaCarta.tribu) || carta.color.equals(nuevaCarta.color))) {
                banda.add(carta);
            }
        }

        if (banda.size() >= 1) {
            bandasJugadas.add(banda);
            cartaJugador.removeAll(banda);
            return true;
        }

        return false;
    }

    public List<List<Carta>> obtenerBandasPosibles(List<Carta> cartaJugador) {
        List<List<Carta>> posiblesBandas = new ArrayList<>();
        Set<Carta> procesadas = new HashSet<>();

        for (Carta carta : cartaJugador) {
            if (!procesadas.contains(carta)) {
                List<Carta> bandaPorTribu = new ArrayList<>();
                bandaPorTribu.add(carta);
                for (Carta otraCarta : cartaJugador) {
                    if (otraCarta != carta && otraCarta.tribu.equals(carta.tribu)) {
                        bandaPorTribu.add(otraCarta);
                    }
                }
                if (!bandaPorTribu.isEmpty()) {
                    posiblesBandas.add(bandaPorTribu);
                }
                procesadas.addAll(bandaPorTribu);
            }
        }

        for (Carta carta : cartaJugador) {
            if (!procesadas.contains(carta)) {
                List<Carta> bandaPorColor = new ArrayList<>();
                bandaPorColor.add(carta);
                for (Carta otraCarta : cartaJugador) {
                    if (otraCarta != carta && otraCarta.color.equals(carta.color)) {
                        bandaPorColor.add(otraCarta);
                    }
                }
                if (!bandaPorColor.isEmpty()) {
                    posiblesBandas.add(bandaPorColor);
                }
                procesadas.addAll(bandaPorColor);
            }
        }

        return posiblesBandas;
    }

    public List<List<Carta>> getBandasJugadas() {
        return bandasJugadas;
    }

    @Override
    public String toString() {
        return "Bandas jugadas: " + bandasJugadas;
    }
}
