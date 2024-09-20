package edu.uca;

import java.util.*;

public class Mazo {
    private List<Carta> deck = new ArrayList<>();

    public Mazo() {
    }

    public void addCarta(Carta card) {
        deck.add(card);
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Carta sacarCarta() {
        if (!deck.isEmpty()) {
            return deck.remove(0);
        }
        return null;
    }

    public int size() {
        return deck.size();
    }

    public void inicio() {
        List<Tribu> tribus = new ArrayList<>(Arrays.asList(Tribu.values()));
        tribus.remove(Tribu.Dragon);
        tribus.remove(Tribu.Esqueleto);
        List<Color> colores = new ArrayList<>(Arrays.asList(Color.values()));
        colores.remove(Color.Negro);
        for (Color color : colores) {
            for (Tribu tribu : tribus) {
                deck.add(new Carta(tribu, color));
                deck.add(new Carta(tribu, color));
            }
        }
        for (int i = 1; i <= 12; i++) {
            deck.add(new Carta(Tribu.Esqueleto, Color.Negro));
        }
        for (Color color : colores) {
            deck.add(new Carta(Tribu.Halfling, color));
            deck.add(new Carta(Tribu.Halfling, color));
        }
        Collections.shuffle(deck);
        List<List<Carta>> dividedLists = splitList(deck);
        List<Carta> mitadDeArriba = dividedLists.get(0);
        List<Carta> mitadDeAbajo = dividedLists.get(1);

        for (int i = 1; i <= 3; i++) {
            mitadDeAbajo.add(new Carta(Tribu.Dragon, Color.Negro));
        }
        Collections.shuffle(mitadDeAbajo);
        deck = new ArrayList<>(mitadDeArriba);
        deck.addAll(mitadDeAbajo);
    }


    public static <T> List<List<T>> splitList(List<T> list) {
        int size = list.size();
        int midpoint = size / 2;

        if (size % 2 != 0) {
            midpoint += 1;
        }

        List<T> firstHalf = new ArrayList<>(list.subList(0, midpoint));
        List<T> secondHalf = new ArrayList<>(list.subList(midpoint, size));

        List<List<T>> result = new ArrayList<>();
        result.add(firstHalf);
        result.add(secondHalf);

        return result;
    }
}
