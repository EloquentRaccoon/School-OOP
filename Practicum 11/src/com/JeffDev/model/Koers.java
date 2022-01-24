package com.JeffDev.model;

import java.util.ArrayList;
import java.util.List;

public class Koers {
    private static Koers koers;
    public static void setKoers(Koers koers1) {
        koers = koers1;
    }
    public static Koers getKoers() {
        return koers;
    }

    private List<Currency> alleCurrencies = new ArrayList<>();

    public Koers(List<Currency> currencies){
        alleCurrencies = currencies;

        for (Currency currency : currencies) {
            if (!alleCurrencies.contains(currency)) {
                alleCurrencies.add(currency);
            }
        }
    }

    public List<Currency> getCurrencies(){
        return alleCurrencies;
    }

    public void addCurrency(Currency currency){
        alleCurrencies.add(currency);
    }


}
