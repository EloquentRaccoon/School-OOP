package com.JeffDev.P4b;

import java.text.DecimalFormat;

public class P4b {
    public static void main(String[] args) {
        AutoHuur ah1 = new AutoHuur();
        System.out.println("Eerste autohuur:\n" + ah1 + "\n");

        Klant k = new Klant("Mijnheer de Vries");
        k.setKorting(10.0);
        ah1.setHuurder(k);
        System.out.println("Eerste autohuur:\n" + ah1 + "\n");

        Auto a1 = new Auto("Peugeot 207", 50);
        ah1.setGehuurdeAuto(a1);
        ah1.setAantalDagen(4);
        System.out.println("Eerste autohuur:\n" + ah1 + "\n");

        AutoHuur ah2 = new AutoHuur();
        Auto a2 = new Auto("Ferrari", 3500);
        ah2.setGehuurdeAuto(a2);
        ah2.setHuurder(k);
        ah2.setAantalDagen(1);
        System.out.println("Tweede autohuur:\n" + ah2 + "\n");

        System.out.println("Gehuurd: " + ah1.getGehuurdeAuto());
        System.out.println("Gehuurd: " + ah2.getGehuurdeAuto());
    }
}

class AutoHuur{
    private int aantalDagen;
    private Auto auto;
    private Klant huurder;

    public AutoHuur(){}

    public void setAantalDagen(int aantalDagen){
        this.aantalDagen = aantalDagen;
    }

    public int getAantalDagen() {
        return aantalDagen;
    }

    public void setGehuurdeAuto(Auto auto){
        this.auto = auto;
    }

    public Auto getGehuurdeAuto(){
        return auto;
    }

    public void setHuurder(Klant huurder){
        this.huurder = huurder;
    }

    public Klant getHuurder() {
        return huurder;
    }

    public double totaalPrijs(){
        if(auto != null){
            if (huurder.getKortingPercentage() > 0){
                return (auto.getPrijsPerDag() * aantalDagen) / 100 * huurder.getKortingPercentage();
            } else {
                return auto.getPrijsPerDag() * aantalDagen;
            }
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        String string = "";
        if(huurder == null && auto == null){
            string = "er is geen auto bekend\r\ner is geen huurder bekend";
        } else if (auto == null){
            string = "er is geen auto bekend\r\nop de naam van: " + huurder;
        }
        return String.format("%s\r\naantal dagen: %s en dat kost %s", string, aantalDagen, df.format(totaalPrijs()));
    }
}

class Auto{
    private final String type;
    private double prijsPerDag;

    public Auto(String type, double prijsPerDag){
        this.type = type;
        this.prijsPerDag = prijsPerDag;
    }

    public void setPrijsPerDag(double prijsPerDag) {
        this.prijsPerDag = prijsPerDag;
    }

    public double getPrijsPerDag() {
        return prijsPerDag;
    }

    @Override
    public String toString() {
        return String.format("%s met de prijs %.2f", type , prijsPerDag);
    }
}

class Klant{
    private final String naam;
    private double kortingPercentage;

    public Klant(String naam){
        this.naam = naam;
    }

    public void setKorting(double kortingPercentage) {
        this.kortingPercentage = kortingPercentage;
    }

    public double getKortingPercentage() {
        return kortingPercentage;
    }

    @Override
    public String toString() {
        return String.format("%s1 (Korting: %.2f%%)", naam ,getKortingPercentage());
    }
}