package edu.uca;

import picocli.CommandLine;

@CommandLine.Command(name = "tienda", mixinStandardHelpOptions = true, version = "1.0",
        description = "sistema de manejo interactivo del stock de la tienda")
public class Main implements Runnable {

    public static void main(String[] args) {
        new CommandLine(new Main()).execute(args);
    }

    @Override
    public void run() {
        Region region = new Region(10, 20, 30, "asd", "rojo");
        System.out.print(region);
    }

}