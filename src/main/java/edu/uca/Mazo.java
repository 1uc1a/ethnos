package edu.uca;

import java.util.*;

public class Mazo {
    private List<Carta> deck;

    public Mazo(int flag) {
        this.deck = new ArrayList<>();
        if (flag == 1) {
            Inicio();
        }
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

    private void Inicio() {
        String[] tribus = {"Orcos", "Merfolk", "Esqueleto", "Halfling", "Minotauros", "Magos"};
        String[] color = {"Naranja", "Naranja", "Verde", "Verde", "Gris", "Gris", "Azul", "Azul", "Violeta", "Violeta", "Rojo", "Rojo"};

        for (String color_ : color) {
            for (String tribu_ : tribus) {
                deck.add(new Carta(tribu_, color_));
                deck.add(new Carta(tribu_, color_));
            }
        }
    }

    @Override
    public String toString() {
        return deck.toString();
    }
}
