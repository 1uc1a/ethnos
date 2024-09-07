package edu.uca;

import java.util.ArrayList;
import java.util.List;

public class Mapa {
    List<Region> mapa;

    public void Mapa(int cantJugadores){
        PuntosRegion puntosRegion = new PuntosRegion(cantJugadores);
        mapa = new ArrayList<Region>();
        mapa.add(new Region())
    }
}
