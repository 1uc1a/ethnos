package edu.uca;

import java.util.List;
import java.util.Scanner;


public class Jugador {
    List<Carta> mano;
    int puntaje;
    int bandasJugadas;
    int fichasMapa;
    String nombre;
    Banda banda;

    public Jugador(List<Carta> mano, int puntaje, int bandasJugadas, int fichasMapa, String nombre, Banda banda) {
        this.mano = mano;
        this.puntaje = puntaje;
        this.bandasJugadas = bandasJugadas;
        this.fichasMapa = fichasMapa;
        this.nombre = nombre;
        this.banda = banda;
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

    public boolean seleccionarYJugarBanda(Banda banda, Mapa mapa) {
        List<List<Carta>> posiblesBandas = banda.obtenerBandasPosibles(mano);

        if (posiblesBandas.isEmpty()) {
            System.out.println(nombre + " no puede formar ninguna banda.");
            return true;
        }

        System.out.println("Posibles bandas");
        for (int i = 0; i < posiblesBandas.size(); i++) {
            System.out.println((i + 1) + ": " + posiblesBandas.get(i));
        }

        System.out.println("0: No seleccionar ninguna banda y continuar jugando.");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Selecciona una banda para jugar");
        int seleccion = scanner.nextInt();

        if (seleccion == 0) {
            return false;
        }

        if (seleccion < 1 || seleccion > posiblesBandas.size()) {
            System.out.println("Selección inválida.");
            return true;
        }

        List<Carta> bandaSeleccionada = posiblesBandas.get(seleccion - 1);
        System.out.println("Banda seleccionada: " + bandaSeleccionada);

        System.out.print("Selecciona el líder de la banda");
        int liderSeleccion = scanner.nextInt();

        if (liderSeleccion < 1 || liderSeleccion > bandaSeleccionada.size()) {
            System.out.println("Selección inválida.");
            return true;
        }

        Carta lider = bandaSeleccionada.get(liderSeleccion - 1);
        System.out.println("Líder seleccionado: " + lider);

        if (banda.formarBanda(mano, lider)) {
            Region region = mapa.getRegionByColor(lider.getColor());
            if (region != null) {
                region.colocarFichas(this.nombre);
                System.out.println("Banda jugada: " + bandaSeleccionada);
            } else {
                System.out.println("No se encontró la región para el color: " + lider.getColor());
            }
            return true;
        } else {
            System.out.println("No se pudo formar la banda.");
            return true;
        }
    }

    public void mostrarBandasJugadas() {
        List<List<Carta>> bandasJugadas = banda.getBandasJugadas();

        if (bandasJugadas.isEmpty()) {
            System.out.println(nombre + " no ha jugado ninguna banda.");
        } else {
            System.out.println("Bandas jugadas por " + nombre + ":");
            for (int i = 0; i < bandasJugadas.size(); i++) {
                System.out.println((i + 1) + ": " + bandasJugadas.get(i));
            }
        }
    }

    @Override
    public String toString() {
        return nombre + " - Mano=" + mano + " - Puntaje: " + puntaje;
    }
}
