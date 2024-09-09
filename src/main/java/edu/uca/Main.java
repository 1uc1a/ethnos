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
        PuntosRegion puntosRegion = new PuntosRegion(3);
        System.out.println(puntosRegion.asignarPuntoARegion());
        Mapa mapa = new Mapa();
        System.out.println(mapa);

        //System.out.print(region);
    }


}