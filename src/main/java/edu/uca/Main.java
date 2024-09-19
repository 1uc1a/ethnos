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
        List<Carta> frente = new ArrayList<>();
        List<Jugador> jugadoresList = new ArrayList<>();
        Banda banda = new Banda(); // Single Banda instance for all players

        System.out.println("Ingrese cantidad jugadores");
        int cant = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < cant; i++) {
            System.out.println("Ingresa el nombre del jugador " + (i + 1) + ":");
            String nombreJugador = scanner.nextLine();
            List<Carta> cartas = new ArrayList<>();
            Jugador jugador = new Jugador(cartas, 0, 0, 0, nombreJugador, banda);
            jugadoresList.add(jugador);
        }

        Mapa mapa = new Mapa(cant);
        Mazo mazo = new Mazo();
        mazo.inicio();

        for (int j = 0; j < cant * 2; j++) {
            frente.add(mazo.sacarCarta());
        }

        while (true) {
            for (int i = 0; i < jugadoresList.size(); i++) {
                Jugador jugador_ = jugadoresList.get(i);

                System.out.println("Es el turno de " + jugador_.getNombre());
                System.out.println("Deck frente");
                System.out.println(frente);

                boolean endTurn = false;

                do {
                    System.out.println("Que queres hacer " + jugador_.getNombre() + "?");
                    System.out.println("1. Sacar carta mazo");
                    System.out.println("2. Sacar carta frente");
                    System.out.println("3. Ver bandas formadas");
                    System.out.println("4. Ver posibles bandas");
                    System.out.println("5. Ver mano");
                    System.out.println("6. Ver mapa");
                    System.out.println("7. Salir");

                    int choice = Integer.parseInt(scanner.nextLine());

                    switch (choice) {
                        case 1:
                            Carta cartaJugada = mazo.sacarCarta();
                            if(cartaJugada.getTribu() == Tribu.Dragon){
                                System.out.println("Dragooooon");
                                Carta nueva_Carta = mazo.sacarCarta();
                                jugador_.anadirCarta(cartaJugada);
                            }else {
                                jugador_.anadirCarta(cartaJugada);
                            }
                            endTurn = true;
                            break;
                        case 2:
                            System.out.println("Ingrese el índice de la carta que quiere sacar del frente (0 a " + (frente.size() - 1) + "):");
                            int index = Integer.parseInt(scanner.nextLine());

                            if (index >= 0 && index < frente.size()) {
                                Carta cartaSeleccionada = frente.get(index);
                                frente.remove(index);
                                jugador_.anadirCarta(cartaSeleccionada);
                                System.out.println("Carta seleccionada: " + cartaSeleccionada);
                                endTurn = true;
                            } else {
                                System.out.println("Índice fuera de rango. Intente nuevamente.");
                            }
                            break;
                        case 3:
                            System.out.println("Bandas jugadas por el jugador:");
                            jugador_.mostrarBandasJugadas();
                            break;
                        case 4:
                            System.out.println("Posibles Bandas:");
                            endTurn = jugador_.seleccionarYJugarBanda(banda, mapa);
                            break;
                        case 5:
                            System.out.println("Mano de " + jugador_.getNombre() + jugador_.getCartas());
                            break;
                        case 6:
                            System.out.println(mapa);
                            System.out.println(mapa.getFichasDeTodasLasRegiones());
                            break;
                        case 7:
                            System.out.println("Saliendo");
                            return;
                        default:
                            System.out.println("Opción inválida, intente nuevamente.");
                    }
                } while (!endTurn);
            }
        }
    }
}
