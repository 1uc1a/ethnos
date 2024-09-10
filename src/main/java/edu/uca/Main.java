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
        List<Cartas> cartas = new ArrayList<>();
        List<Jugadores> jugadoresList = new ArrayList<>();

        System.out.println("Ingrese cant jugadores");
        int cant = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < cant; i++) {
            Jugadores jugador = new Jugadores(cartas, 0, 0, 0);
            jugadoresList.add(jugador);
        }

        System.out.println(jugadoresList);

        Mapa mapa = new Mapa(3);
        System.out.println(mapa);
        Mazo mazo = new Mazo(1);
        mazo.shuffle();
        frente.addCarta(mazo.sacarCarta());
        frente.addCarta(mazo.sacarCarta());
        frente.addCarta(mazo.sacarCarta());
        frente.addCarta(mazo.sacarCarta());
        frente.addCarta(mazo.sacarCarta());
        frente.addCarta(mazo.sacarCarta());
    while(true){
        for (Jugadores jugador : jugadoresList) {
            System.out.println(jugador);
            System.out.println("Que queres hacer");
            System.out.println("1. Sacar carta mazo");
            System.out.println("2. Sacar carta frente");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    jugador.anadirCarta(mazo.sacarCarta());
                    break;
                case 2:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida, intente nuevamente.");
            }
        }
    }






        //System.out.print(region);
    }


}