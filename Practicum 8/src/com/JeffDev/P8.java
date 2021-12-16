package com.JeffDev;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class P8 {
    public static void main(String[] args) {
        BedrijfsInventaris bedrijf1 = new BedrijfsInventaris("HU", 25000);

        Auto auto1 = new Auto("Mercedes-Benz A-klasse A 180", 29995.00, 2019, "4-ZTV-94"); //auto 1
        Auto auto2 = new Auto("Mercedes-Benz A-klasse A 180", 29995.00, 2019, "4-ZTV-94"); //auto 1
        bedrijf1.schafAan(auto1);
        bedrijf1.schafAan(auto2);
        bedrijf1.schafAan(new Auto("Mercedes-Benz A-klasse A 180", 250000.00,2016,"8-TDT-58"));

        bedrijf1.schafAan(new Computer("Intel" ,"3B:22:14:82:B9:F2", 1299.99,2021)); // computer 1
        bedrijf1.schafAan(new Computer("Intel" ,"3B:22:14:82:B9:F2", 1299.99,2021)); // computer 1
        bedrijf1.schafAan(new Computer("Dell" ,"2C:54:91:88:C9:E3", 999.99,2020));

        bedrijf1.schafAan(new Fiets("Oma-fiets", 499.99, 2016, 1)); // fiets 1
        bedrijf1.schafAan(new Fiets("Oma-fiets", 499.99, 2016, 1)); // fiets 1

        bedrijf1.schafAan(new Fiets("Oma-fiets", 199.99, 2012, 2));
        bedrijf1.schafAan(new Fiets("Gazelle", 699.99, 2018, 3));
        bedrijf1.schafAan(new Fiets("Elektrische fiets", 999.99, 2021, 4));


        System.out.println(bedrijf1.toString());
    }
}

interface Goed {
    public double huidigeWaarde();
}

class BedrijfsInventaris {
    private String bedrijfsnaam ;
    private double budget;
    public ArrayList<Goed> alleGoederen = new ArrayList<>();

    BedrijfsInventaris(String bedrijfsnaam, double budget) {
        this.bedrijfsnaam = bedrijfsnaam;
        this.budget = budget;
    }

    public void schafAan(Goed aankoop) {
        boolean buy = true;
        if (alleGoederen.isEmpty()) {
            if (budget < aankoop.huidigeWaarde()) {
               buy = false;
            }
        } else {
            for (Goed goed : alleGoederen) {
                if (goed.equals(aankoop) || budget < aankoop.huidigeWaarde()) {
                    buy = false;
                }
            }
        }
        if (buy){
            alleGoederen.add(aankoop);
            budget = budget - aankoop.huidigeWaarde();
        }
    }

    @Override
    public String toString() {
        String results = "";
        for (Goed goed : alleGoederen) {
            results += goed.toString() + "\n"; // Use the toString of planet and add a new line
        }

        return String.format("Goederen vam bedrijf %s zijn: \n%s \nbudget over: €%.2f", bedrijfsnaam, results, budget);
    }
}

class Computer implements Goed {
    private final String type;
    private final String macAdres;
    private final double aanschafPrijs;
    private final int productieJaar;

    Computer(String type, String macAdres, double aanschafPrijs, int productieJaar) {
        this.type = type;
        this.macAdres = macAdres;
        this.aanschafPrijs = aanschafPrijs;
        this.productieJaar = productieJaar;
    }

    @Override
    public double huidigeWaarde() {
        int currentDate = LocalDate.now().getYear();
        double huidigePrijs = aanschafPrijs;
        if (currentDate > productieJaar) {
            for (int i = 0; i < currentDate - productieJaar; i++) {
                huidigePrijs = huidigePrijs * 0.6;
            }
        }
        return huidigePrijs;
    }

    @Override
    public boolean equals(Object pc) {
        if (this == pc) return true;
        if (pc == null || getClass() != pc.getClass()) return false;
        Computer computer = (Computer) pc;
        return productieJaar == computer.productieJaar && Objects.equals(type, computer.type) && Objects.equals(macAdres, computer.macAdres);
    }

    @Override
    public String toString() {
        return String.format("Computer: %s met bouwjaar %s heeft een waarde van: €%.2f", type, productieJaar, huidigeWaarde());
    }
}

abstract class Voertuig implements Goed {
    protected String type;
    protected double prijs;
    protected int jaar;

    Voertuig() {
    }

    Voertuig(String type, double prijs, int jaar) {
        this.type = type;
        this.prijs = prijs;
        this.jaar = jaar;
    }

    public double huidigeWaarde(double rente) {
        int currentDate = LocalDate.now().getYear();
        double huidigePrijs = prijs;
        if (currentDate > jaar) {
            for (int i = 0; i < currentDate - jaar; i++) {
                huidigePrijs = huidigePrijs * rente;
            }
        }
        return huidigePrijs;
    }



    @Override
    public String toString() {
        return String.format("Voertuig: %s met bouwjaar %s heeft een waarde van: €%.2f", type, jaar, huidigeWaarde());
    }
}

class Auto extends Voertuig {
    private final String kenteken;

    Auto(String type, double prijs, int jaar, String kenteken) {
        this.type = type;
        this.prijs = prijs;
        this.jaar = jaar;
        this.kenteken = kenteken;
    }

    @Override
    public boolean equals(Object auto) {
        if (this == auto) return true;
        if (auto == null || getClass() != auto.getClass()) return false;
        Auto checkVoertuig = (Auto) auto;
        return jaar == checkVoertuig.jaar && Objects.equals(type, checkVoertuig.type) && Objects.equals(kenteken, checkVoertuig.kenteken);
    }

    @Override
    public double huidigeWaarde() {
        return super.huidigeWaarde(0.7);
    }

}

class Fiets extends Voertuig {
    private final int framenummer;

    Fiets(String type, double prijs, int jaar, int framenummer) {
        this.type = type;
        this.prijs = prijs;
        this.jaar = jaar;
        this.framenummer = framenummer;
    }

    @Override
    public boolean equals(Object fiets) {
        if (this == fiets) return true;
        if (fiets == null || getClass() != fiets.getClass()) return false;
        Fiets checkVoertuig = (Fiets) fiets;
        return jaar == checkVoertuig.jaar && Objects.equals(type, checkVoertuig.type) && Objects.equals(framenummer,checkVoertuig.framenummer);
    }

    @Override
    public double huidigeWaarde() {
        return super.huidigeWaarde(0.9);
    }

}