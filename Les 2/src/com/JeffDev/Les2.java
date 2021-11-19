package com.JeffDev;

public class Les2 {
    public static void main(String[] arg) {
        Zwembad z1 = new Zwembad(2.0, 5.5, 1.5);
        System.out.println("BREEDTE: " + z1.getBreedte() + " meter");
        System.out.println("LENGTE: " + z1.getLengte() + " meter");
        System.out.println("DIEPTE: " + z1.getDiepte() + " meter");
        System.out.println("BEREKENDE INHOUD: " + z1.inhoud() + " liter");
        System.out.println();

        Zwembad z2 = new Zwembad();
        z2.setBreedte(2.5);
        z2.setLengte(100.0);
        z2.setDiepte(2.0);
        double inh = z2.inhoud();
        System.out.println("GEGEVENS ZWEMBAD: " + z2.toString());
        System.out.println("BEREKENDE INHOUD: " + inh  + " liter");
    }
}
