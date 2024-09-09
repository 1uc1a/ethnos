package edu.uca;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class Mapa {
    List<Region> mapa;
    PuntosRegion puntosRegion;
    List<Integer> puntosAAsignar = new ArrayList<>();


    public Mapa(int cantJugadores){
        puntosRegion = new PuntosRegion(cantJugadores);
        mapa = new ArrayList<Region>();

        if (cantJugadores > 3) {
            mapa.add(new Region("Ithys", "Naranja", 0, 0, 0));
            mapa.add(new Region("Althea", "Verde", 0, 0, 0));
            mapa.add(new Region("Pelagon", "Gris", 0, 0, 0));
            mapa.add(new Region("Straton", "Azul", 0, 0, 0));
            mapa.add(new Region("Duris", "Violeta", 0, 0, 0));
            mapa.add(new Region("Rhea", "Rojo", 0, 0, 0));

        } else {
            mapa.add(new Region("Ithys", "Naranja", 0, 0));
            mapa.add(new Region("Althea", "Verde", 0, 0));
            mapa.add(new Region("Pelagon", "Gris", 0, 0));
            mapa.add(new Region("Straton", "Azul", 0, 0));
            mapa.add(new Region("Duris", "Violeta", 0, 0));
            mapa.add(new Region("Rhea", "Rojo", 0, 0));
            for(Region region : mapa){
                asignarPuntosPocosJugadores(region);
            }
        }
    }

    private void asignarPuntosPocosJugadores(Region region){
        puntosAAsignar.add(puntosRegion.asignarPuntoARegion());
        puntosAAsignar.add(puntosRegion.asignarPuntoARegion());
        Collections.sort(puntosAAsignar);
        region.setPuntaje1(puntosAAsignar.get(puntosAAsignar.getFirst()));
        region.setPuntaje2(puntosAAsignar.get(puntosAAsignar.getLast()));
        puntosAAsignar.clear();
    }

    private void asignarPuntosMuchosJugadores(){
        puntosAAsignar.add(puntosRegion.asignarPuntoARegion());
        puntosAAsignar.add(puntosRegion.asignarPuntoARegion());
        puntosAAsignar.add(puntosRegion.asignarPuntoARegion());
        Collections.sort(puntosAAsignar);

    }

    @Override
    public String toString() {
        return "Mapa=" + mapa;
    }
}

