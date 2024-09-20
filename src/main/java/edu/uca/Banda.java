package edu.uca;

import java.util.*;

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

    public List<List<Carta>> obtenerBandasPosibles(List<Carta> cartas) {
        Map<String, Set<Carta>> colorGroups = new HashMap<>();
        Map<String, Set<Carta>> tribeGroups = new HashMap<>();

        for (Carta carta : cartas) {
            String color = carta.getColor();
            String tribe = String.valueOf(carta.getTribu());

            colorGroups.putIfAbsent(color, new HashSet<>());
            colorGroups.get(color).add(carta);

            tribeGroups.putIfAbsent(tribe, new HashSet<>());
            tribeGroups.get(tribe).add(carta);
        }

        List<List<Carta>> posiblesBandas = new ArrayList<>();

        for (Set<Carta> colorGroup : colorGroups.values()) {
            for (Carta carta : colorGroup) {
                if (!containsBand(posiblesBandas, Collections.singletonList(carta))) {
                    posiblesBandas.add(Collections.singletonList(carta));
                }
            }

            if (colorGroup.size() > 1) {
                List<Carta> bandaColor = new ArrayList<>(colorGroup);
                if (!containsBand(posiblesBandas, bandaColor)) {
                    posiblesBandas.add(bandaColor);
                }
            }
        }

        for (Set<Carta> tribeGroup : tribeGroups.values()) {
            for (Carta carta : tribeGroup) {
                if (!containsBand(posiblesBandas, Collections.singletonList(carta))) {
                    posiblesBandas.add(Collections.singletonList(carta));
                }
            }

            if (tribeGroup.size() > 1) {
                List<Carta> bandaTribu = new ArrayList<>(tribeGroup);
                if (!containsBand(posiblesBandas, bandaTribu)) {
                    posiblesBandas.add(bandaTribu);
                }
            }
        }

        return posiblesBandas;
    }

    private boolean containsBand(List<List<Carta>> posiblesBandas, List<Carta> banda) {
        for (List<Carta> existingBanda : posiblesBandas) {
            if (existingBanda.containsAll(banda) && banda.containsAll(existingBanda)) {
                return true;
            }
        }
        return false;
    }



    public List<List<Carta>> getBandasJugadas() {
        return bandasJugadas;
    }

    @Override
    public String toString() {
        return "Bandas jugadas: " + bandasJugadas;
    }
}
