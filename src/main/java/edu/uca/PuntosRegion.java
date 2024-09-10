package edu.uca;

import java.util.*;

public class PuntosRegion {
    LinkedList<Integer> puntosRegion = new LinkedList<>();

    public PuntosRegion(int cantJugadores) {
        puntosRegion.addAll(Arrays.asList(0, 2, 2, 2, 4, 4, 6, 6, 8, 8, 8, 10));
        if (cantJugadores > 3) {
            List<Integer> masDeCuatro = Arrays.asList(0,4,4,6,6,10);
            puntosRegion.addAll(masDeCuatro);
        }
        Collections.shuffle(puntosRegion);
    }

    public int asignarPuntoARegion(){
        int puntoAASignar = puntosRegion.getFirst();
        puntosRegion.removeFirst();
        return puntoAASignar;
    }
}
