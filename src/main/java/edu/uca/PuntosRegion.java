package edu.uca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PuntosRegion {
    List<Integer> puntosRegion;

    public PuntosRegion(int cantJugadores) {
        puntosRegion = Arrays.asList(0, 2, 2, 2, 4, 4, 6, 6, 8, 8, 8, 10);
        if (cantJugadores > 3) {
            List<Integer> masDeCuatro = Arrays.asList(0,4,4,6,6,10);
            puntosRegion.addAll(masDeCuatro);
        }
        Collections.shuffle(puntosRegion);
    }

    public int asignarPuntoARegion(){
        int puntoAASignar = puntosRegion.get(0);
        puntosRegion.removeFirst();
        return puntoAASignar;
    }
}
