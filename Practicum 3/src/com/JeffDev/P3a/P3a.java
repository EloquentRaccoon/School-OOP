package com.JeffDev.P3a;


public class P3a {
    public static void main(String[] args) throws Exception {
        Voetbalclub ajx = new Voetbalclub("Ajax");
        Voetbalclub feij = new Voetbalclub("Feijenoord");

        feij.verwerkResultaat('w');
        feij.verwerkResultaat('w');
        feij.verwerkResultaat('w');
        feij.verwerkResultaat('g');

        System.out.println("Feijenoord punten: " + feij.getAantalPunten());
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
    private int aantalPunten = 0;
    private final String naam;


    public Voetbalclub(String naam){
        if(naam == null || naam.isEmpty()){
            naam = "FC";
        }
        this.naam = naam;
    }

    public int aantalGespeeld() {
        return aantalGelijk + aantalGewonnen + aantalVerloren;
    }

    public void verwerkResultaat(char ch) throws Exception {
        switch (ch) {
            case 'w' -> {
                aantalGewonnen += 1;
                aantalPunten += 3;
            }
            case 'g' -> {
                aantalGelijk += 1;
                aantalPunten += 1;
            }
            case 'v' -> aantalVerloren += 1;
            default -> throw new Exception("Invalid value");
        }
    }
    public String getNaam(){
        return this.naam;
    }

    public int getAantalPunten(){
        return this.aantalPunten;
    }

    @Override
    public String toString() {
        return String.format("%s: %s gespeeld, %s gewonen, %s gelijk gespeeld, %s  verloren.    Totaal punten: %s ", naam, this.aantalGespeeld(), aantalGewonnen, aantalGelijk, aantalVerloren, aantalPunten);
    }


}
