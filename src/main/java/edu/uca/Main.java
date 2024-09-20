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
        Juego juego = new Juego();
        juego.iniciarJuego();
    }
}
