package com.JeffDev.P2a;

public class P2a {
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
        System.out.println("BEREKENDE INHOUD: " + inh + " liter");
    }
}

class Zwembad {
    //zwembad values.
    private double breedte;
    private double lengte;
    private double diepte;

    //zwembad constructor, values from getters/setters.
    public Zwembad() {

    }

    //zwembad constructor, direct values.
    public Zwembad(double breedte, double lengte, double diepte) {
        setBreedte(breedte);
        setLengte(lengte);
        setDiepte(diepte);
    }

    //Calculate inhoud value of zwembad.
    public double inhoud() {

        return this.lengte * this.breedte * this.diepte * 1000;
    }

    //create string to get info about zwembad.
    public String toString() {
        return String.format("%s meter breedte, %s meter lengte, %s meter diepte.", this.breedte, this.lengte, this.diepte);
    }

    //getters and setters of zwembad values.
    //breedte.
    public double getBreedte() {
        return this.breedte;
    }
    public void setBreedte(double breedte) {
        this.breedte = breedte;
    }

    //lengte.
    public double getLengte() {
        return this.lengte;
    }
    public void setLengte(double lengte) {
        this.lengte = lengte;
    }

    //diepte.
    public double getDiepte() {
        return this.diepte;
    }
    public void setDiepte(double diepte) {
        this.diepte = diepte;
    }
}