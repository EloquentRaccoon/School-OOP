package com.JeffDev.model;

import java.util.ArrayList;
import java.util.List;

public class Currency {
    private String name;
    private double price; //based on 1 USD dollar


    public Currency(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Currency(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String toString() {

        return String.format("%s", name);

    }
}
