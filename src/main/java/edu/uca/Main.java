package edu.uca;

import java.util.ArrayList;
import picocli.CommandLine;

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
        List<Jugador> jugadoresList = new ArrayList<>();
        List<Banda> bandaList = new ArrayList<>();

        System.out.println("Ingrese cant jugadores");
        int cant = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < cant; i++) {
            List<Carta> cartas = new ArrayList<>();
            Jugador jugador = new Jugador(cartas, 0, 0, 0);
            jugadoresList.add(jugador);
            bandaList.add(new Banda());
        }

        Mapa mapa = new Mapa(cant);
        System.out.println(mapa);

        Mazo mazo = new Mazo(1);
        mazo.shuffle();

        for (int j = 0; j < cant * 2; j++) {
            frente.addCarta(mazo.sacarCarta());
        }

        while (true) {
            for (int i = 0; i < jugadoresList.size(); i++) {
                Jugador jugador_ = jugadoresList.get(i);
                Banda banda_ = bandaList.get(i);

                System.out.println(jugadoresList);
                System.out.println(jugador_);
                System.out.println("Deck frente");
                System.out.println(frente);
                System.out.println("Que queres hacer?");
                System.out.println("1. Sacar carta mazo");
                System.out.println("2. Sacar carta frente");
                System.out.println("3. Formar banda");
                System.out.println("4. Ver bandas formadas");
                System.out.println("5. Salir");

                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        jugador_.anadirCarta(mazo.sacarCarta());
                        continue;
                    case 2:
                        System.out.println("Ingrese el índice de la carta que quiere sacar del frente (0 a " + (frente.size() - 1) + "):");
                        int index = Integer.parseInt(scanner.nextLine());

                        if (index >= 0 && index < frente.size()) {
                            Carta cartaSeleccionada = frente.get(index);
                            frente.remover(index);
                            jugador_.anadirCarta(cartaSeleccionada);
                            System.out.println("Carta seleccionada: " + cartaSeleccionada);
                        } else {
                            System.out.println("Índice fuera de rango. Intente nuevamente.");
                        }
                        break;
                    case 3:
                        System.out.println("Seleccione la carta que desea usar para formar una banda (0 a " + (jugador_.getCartas().size() - 1) + "):");
                        int cartaIndex = Integer.parseInt(scanner.nextLine());

                        if (cartaIndex >= 0 && cartaIndex < jugador_.getCartas().size()) {
                            Carta cartaUsar = jugador_.getCartas().get(cartaIndex);
                            boolean bandaFormada = banda_.formarBanda(jugador_.getCartas(), cartaUsar);
                            if (bandaFormada) {
                                System.out.println("Banda formada con éxito!");
                            } else {
                                System.out.println("No se pudo formar una banda.");
                            }
                        } else {
                            System.out.println("Índice fuera de rango. Intente nuevamente.");
                        }
                        break;
                    case 4:
                        System.out.println("Bandas jugadas por el jugador:");
                        System.out.println(banda_);
                        break;
                    case 5:
                        System.out.println("Posibles Bandas:");
                        System.out.println(banda_.obtenerBandasPosibles(jugador_.getCartas()));
                        break;
                    case 6:
                        System.out.println("Saliendo...");
                        return;
                    default:
                        System.out.println("Opción inválida, intente nuevamente.");

                }
            }


            //System.out.print(region);
        }


    }
}