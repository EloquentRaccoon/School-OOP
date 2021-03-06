package com.JeffDev.P6a;

import java.time.LocalDate;
import java.util.ArrayList;

public class P6a {
    public static void main(String[] args) {
        int releaseJaar1 = LocalDate.now().getYear() - 1; // 1 jaar geleden

        Game game1 = new Game("Just Cause 3", releaseJaar1, 49.98);
        Game game2 = new Game("Need for Speed: Rivals", releaseJaar1, 45.99);
        Game game3 = new Game("Need for Speed: Rivals", releaseJaar1, 45.99);

        Persoon persoon1 = new Persoon("Eric", 200);
        Persoon persoon2 = new Persoon("Hans", 55);

        System.out.println("p1 koopt g1:" + (persoon1.koop(game1) ? "" : " niet") + " gelukt");
        System.out.println("p1 koopt g2:" + (persoon1.koop(game2) ? "" : " niet") + " gelukt");
        System.out.println("p1 koopt g3:" + (persoon1.koop(game3) ? "" : " niet") + " gelukt");
        System.out.println("\np1: " + persoon1 + "\n\np2: " + persoon2 + "\n");

        System.out.println("p1 verkoopt g2 aan p2:" + (persoon1.verkoop(game2, persoon2) ? "" : " niet") + " gelukt");
        System.out.println("p1 verkoopt g1 aan p2:" + (persoon1.verkoop(game1, persoon2) ? "" : " niet") + " gelukt");
        System.out.println("\np1: " + persoon1 + "\n\np2: " + persoon2 + "\n");
    }
}

class Persoon {
    private final String naam;
    private double budget;
    private final ArrayList<Game> gameList = new ArrayList<Game>();

    public Persoon(String naam, double budget) {
        this.budget = budget;
        this.naam = naam;
    }

    public double getBudget() {
        return budget;
    }

    public boolean koop(Game newGame) {
        if (budget > newGame.huidigeWaarde()) {
            if (gameList.contains(newGame)) {
                return false;
            }
            gameList.add(newGame);
            budget = budget - newGame.huidigeWaarde();
            return true;
        }
        return false;
    }

    public boolean verkoop(Game sellGame, Persoon koper) {
        if (gameList.contains(sellGame)) {
            if (koper.koop(sellGame)) {
                budget = budget + sellGame.huidigeWaarde();
                gameList.remove(sellGame);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        for (Game game : gameList) {
            list.append(game.toString());
        }
        return String.format("%s heeft een budget van ???%.2f en bezit de volgende games:%s", naam, budget, list);
    }
}

class Game {
    private final String naam;
    private final int releaseJaar;
    public double nieuwPrijs;

    public Game(String naam, int releaseJaar, double nieuwPrijs) {
        this.naam = naam;
        this.releaseJaar = releaseJaar;
        this.nieuwPrijs = nieuwPrijs;
    }

    public String getNaam() {
        return naam;
    }

    public Double huidigeWaarde() {

        int currentDate = LocalDate.now().getYear();
        double prijs = nieuwPrijs;
        if (currentDate > releaseJaar) {

            int verschil = currentDate - releaseJaar;
            for (int i = 0; i < verschil; i++) {
                prijs = prijs * 0.7;
            }
        }
        return prijs;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Game game) {
            return (game.releaseJaar == this.releaseJaar && game.naam.equals(this.naam));
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("\n%s, uitgegeven in %s; nieuwprijs: ???%.2f nu voor: ???%.2f", naam, releaseJaar, nieuwPrijs, huidigeWaarde());
    }
}

