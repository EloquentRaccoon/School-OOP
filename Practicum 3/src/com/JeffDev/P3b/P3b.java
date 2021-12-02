package com.JeffDev.P3b;

public class P3b {
    public static void main(String[] args) {
        Cirkel c1 = null, c2 = null;

        try {
            c1 = new Cirkel("c1",10, 0, 0);
            c2 = new Cirkel("c2",0, 10, 10);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

        System.out.println(c1);
        System.out.println(c2);
    }
}

class Cirkel {
    private final String name;
    private final int radius;
    private final int xPositive;
    private final int yPositive;

    public Cirkel(String name, int radius, int xPositive, int yPositive){
        if(radius <= 0 ){
            throw new IllegalArgumentException("Radius moet groter dan 0 zijn! Controlleer Cirkel: " + name);
        } else {
            this.name = name;
            this.radius = radius;
            this.xPositive = xPositive;
            this.yPositive = yPositive;
        }
    }

    @Override
    public String toString() {
        return String.format("Cirkel: %s (%s, %s) met radius: %s",this.name, this.xPositive, this.yPositive, this.radius);
    }
}
