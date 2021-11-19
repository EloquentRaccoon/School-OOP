package com.JeffDev;

public class Les2 {
    public static void main(String[] arg) {
        //create new zwembad z1.
        Zwembad z1 = new Zwembad(2.0, 5.5, 1.5);

        //write values of zwembad z1.
        System.out.println("BREEDTE: " + z1.getBreedte() + " meter");
        System.out.println("LENGTE: " + z1.getLengte() + " meter");
        System.out.println("DIEPTE: " + z1.getDiepte() + " meter");

        //write inhoud of zwembad z1.
        System.out.println("BEREKENDE INHOUD: " + z1.inhoud() + " liter");
        System.out.println();

        //create new zwembad z2.
        Zwembad z2 = new Zwembad();

        //set values of zwembad z2.
        z2.setBreedte(2.5);
        z2.setLengte(100.0);
        z2.setDiepte(2.0);

        //get inhoud of zwembad z2.
        double inh = z2.inhoud();

        //z2 is enough to print all the info, since there is a toString value in the class.
        System.out.println("GEGEVENS ZWEMBAD: " + z2);
        System.out.println("BEREKENDE INHOUD: " + inh  + " liter");
    }
}
