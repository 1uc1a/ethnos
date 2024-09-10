package edu.uca;

import edu.uca.PuntosRegion;
import java.util.ArrayList;
import picocli.CommandLine;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@CommandLine.Command(name = "", mixinStandardHelpOptions = true, version = "1.0",
        description = "")
public class Main implements Runnable {


    public static void main(String[] args) {
        new CommandLine(new Main()).execute(args);
    }

    @Override
    public void run() {
        Mapa mapa = new Mapa(3);
        System.out.println(mapa);
        Mazo mazo = new Mazo();
        mazo.shuffle();
        System.out.println(mazo);
        System.out.println(mazo.sacarCarta());

        //System.out.print(region);
    }


}