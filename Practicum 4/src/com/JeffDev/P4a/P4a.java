package com.JeffDev.P4a;

public class P4a {
    public static void main(String[] args) {
        Huis h1 = new Huis("Nijenoord 1", 1970);
        Persoon p1 = new Persoon("Ronald Plasterk", 52);
        h1.setHuisbaas(p1);
        System.out.println(h1);
        System.out.println();

        Huis h2 = new Huis("Vredenburg", 1991);
        Persoon p2 = new Persoon("Annie Brouwers", 59);
        h2.setHuisbaas(p2);
        System.out.println(h2);
        System.out.println();
        System.out.println("Huisbaas 1: " + h1.getHuisbaas());
        System.out.println("Huisbaas 2: " + h2.getHuisbaas());
    }
}

class Huis {
    private final String adres;
    private final int bouwjaar;
    private Persoon huisbaas;

    public Huis(String adres, int bouwjaar) {
        this.adres = adres;
        this.bouwjaar = bouwjaar;
    }

    public void setHuisbaas(Persoon huisbaas) {
        this.huisbaas = huisbaas;
    }

    public Persoon getHuisbaas() {
        return huisbaas;
    }

    @Override
    public String toString() {
        return String.format("Huis %s is gebouwd in %s \r\nen heeft huisbaas %s", bouwjaar, adres, huisbaas);
    }
}

class Persoon {
    private final String naam;
    private final int leeftijd;

    public Persoon(String naam, int leeftijd) {
        this.naam = naam;
        this.leeftijd = leeftijd;
    }

    @Override
    public String toString() {
        return String.format("%s; leeftijd %s jaar", naam, leeftijd);
    }
}