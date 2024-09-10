package edu.uca;

import java.util.*;

public class Mazo {
    private List<Cartas> deck;
    public Mazo() {
        this.deck = new ArrayList<>();
        Inicio();
    }

    public void addCarta(Cartas card) {
        deck.add(card);
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Cartas sacarCarta() {
        if (!deck.isEmpty()) {
            return deck.remove(0);
        }
        return null;
    }

    private void Inicio() {
        String[] tribus = {"Orcos", "Merfolk", "Esqueleto", "Halfling", "Minotauros", "Magos"};
        String[] color = {"Naranja", "Naranja", "Verde", "Verde", "Gris", "Gris", "Azul", "Azul", "Violeta", "Violeta", "Rojo", "Rojo"};

        for (String color_ : color) {
            for (String tribu_ : tribus) {
                deck.add(new Cartas(tribu_, color_));
                deck.add(new Cartas(tribu_, color_));
            }
        }
    }

    @Override
    public String toString() {
        return "Deck=" + deck;
    }
}