package edu.uca;

import edu.uca.PuntosRegion;
import java.util.ArrayList;
import picocli.CommandLine;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@CommandLine.Command(name = "", mixinStandardHelpOptions = true, version = "1.0",
        description = "")
public class Main implements Runnable {
    private Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        new CommandLine(new Main()).execute(args);
    }

    @Override
    public void run() {
        Mazo frente = new Mazo(0);
        List<Jugadores> jugadoresList = new ArrayList<>();

        System.out.println("Ingrese cant jugadores");
        int cant = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < cant; i++) {
            List<Cartas> cartas = new ArrayList<>();
            Jugadores jugador = new Jugadores(cartas, 0, 0, 0);
            jugadoresList.add(jugador);
        }

        Mapa mapa = new Mapa(cant);
        System.out.println(mapa);

        Mazo mazo = new Mazo(1);

        mazo.shuffle();
        for (int j = 0; j < cant*2; j++){
            frente.addCarta(mazo.sacarCarta());
        }
        while (true) {
            for (Jugadores jugador_ : jugadoresList) {
                System.out.println(jugadoresList);
                System.out.println(jugador_);
                System.out.println("Deck frente");
                System.out.println(frente);
                System.out.println("Que queres hacer");
                System.out.println("1. Sacar carta mazo");
                System.out.println("2. Sacar carta frente");
                System.out.println("3. Salir");

                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        jugador_.anadirCarta(mazo.sacarCarta());
                        continue;
                    case 3:
                        System.out.println("Saliendo...");
                        return;
                    case 2:
                        System.out.println("Ingrese el índice de la carta que quiere sacar del frente (0 a " + (frente.size() - 1) + "):");
                        int index = Integer.parseInt(scanner.nextLine());

                        if (index >= 0 && index < frente.size()) {
                            Cartas cartaSeleccionada = frente.get(index);
                            frente.remover(index);
                            jugador_.anadirCarta(cartaSeleccionada);
                            System.out.println("Carta seleccionada: " + cartaSeleccionada);
                        } else {
                            System.out.println("Índice fuera de rango. Intente nuevamente.");
                        }
                    default:
                        System.out.println("Opción inválida, intente nuevamente.");
                }
            }
        }






        //System.out.print(region);
    }


}