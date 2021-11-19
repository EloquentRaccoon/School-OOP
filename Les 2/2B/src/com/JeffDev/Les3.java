package com.JeffDev;

public class Les3 {
    public static void main(String[] args) throws Exception {
        Voetbalclub ajx = new Voetbalclub("Ajax      ");
        Voetbalclub feij = new Voetbalclub("Feijenoord");

        feij.verwerkResultaat('w');
        feij.verwerkResultaat('w');
        feij.verwerkResultaat('w');
        feij.verwerkResultaat('g');

        System.out.println("Feijenoord punten: " + feij.aantalPunten());
        System.out.println("Ajax gespeeld: " + ajx.aantalGespeeld());
        System.out.println();

        System.out.println(ajx);
        System.out.println(feij);
    }
}

class Voetbalclub {
    private int aantalGewonnen = 0;
    private int aantalVerloren = 0;
    private int aantalGelijk = 0;
    private String naam;

    public Voetbalclub(String naam){
        this.naam = naam;
    }

    public int aantalGespeeld() {
        return aantalGelijk + aantalGewonnen + aantalVerloren;
    }

    public int aantalPunten() {
        return (aantalGewonnen * 3) + aantalGelijk;
    }

    public void verwerkResultaat(char ch) throws Exception {
        switch (ch) {
            case 'w' -> aantalGewonnen = aantalGewonnen + 1;
            case 'g' -> aantalGelijk = aantalGelijk + 1;
            case 'v' -> aantalVerloren = aantalVerloren + 1;
            default -> throw new Exception("Invalid value");
        }
    }
    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s", naam, this.aantalGespeeld(), aantalGewonnen, aantalGelijk, aantalVerloren, aantalPunten());
    }
}
