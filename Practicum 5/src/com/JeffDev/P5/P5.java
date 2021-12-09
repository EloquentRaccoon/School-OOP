package com.JeffDev.P5;


import java.util.ArrayList;


public class P5 {
    public static void main(String[] arg) {
        Klas k = new Klas("V1Z");
        Leerling l = new Leerling("Hans");
        k.voegLeerlingToe(l);
        l = new Leerling("Jan");
        k.voegLeerlingToe(l);
        l = new Leerling("Wim");
        k.voegLeerlingToe(l);
        System.out.println(k);
        k.wijzigCijfer(new String("Hans"), 7.6);
        k.wijzigCijfer("Klaas", 7.6);
        System.out.println(k.toString());
        System.out.println("Aantal leerlingen: " + k.aantalLeerlingen());
    }
}

class Klas {
    private final String klasCode;
    private final ArrayList<Leerling> leerlingen = new ArrayList<>();

    public Klas(String klasCode) {
        this.klasCode = klasCode;
    }

    public void voegLeerlingToe(Leerling leerling) {
        leerlingen.add(leerling);
    }

    public void wijzigCijfer(String naam, double newCijfer) {
        if (getLeerlingen().getNaam().equals(naam)) {
            getLeerlingen().setCijfer(newCijfer);
        }
    }

    public Leerling getLeerlingen() {
        for (Leerling leerling : leerlingen) {
            return leerling;
        }
        return null;
    }

    public int aantalLeerlingen() {
        return leerlingen.size();
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        for (Leerling leerling : leerlingen) {
            list.append(leerling.toString());
        }

        return String.format("\nIn de klas %s zitten de volgende leerlingen: %s ", klasCode, list);
    }
}

class Leerling {
    private final String naam;
    private double cijfer;

    public Leerling(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public double getCijfer() {
        return cijfer;
    }

    public void setCijfer(double cijfer) {
        this.cijfer = cijfer;
    }

    @Override
    public String toString() {
        return String.format("\n%s heeft cijfer: %f", naam, cijfer);
    }
}