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

    // Method to get the number of cards in the deck
    public int size() {
        return deck.size();
    }

    // Method to get a specific card by index
    public Carta get(int index) {
        if (index >= 0 && index < deck.size()) {
            return deck.get(index);
        }
        return null; // Return null if the index is invalid
    }

    // Method to remove a specific card by index from the deck
    public Carta remover(int index) {
        if (index >= 0 && index < deck.size()) {
            return deck.remove(index);
        }
        return null; // Return null if the index is invalid
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

        // Manejar casos en los que la lista tiene un número impar de elementos
        if (size % 2 != 0) {
            midpoint += 1;  // Incluye el elemento del medio en la primera mitad
        }

        // Dividir la lista en dos partes
        List<T> firstHalf = new ArrayList<>(list.subList(0, midpoint));
        List<T> secondHalf = new ArrayList<>(list.subList(midpoint, size));

        // Crear una lista de listas para devolver
        List<List<T>> result = new ArrayList<>();
        result.add(firstHalf);
        result.add(secondHalf);

        return result;
    }
}
