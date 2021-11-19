package com.JeffDev;

public class Les1 {

    public static void main(String[] args) {
        opdracht1();
        System.out.println("------------------------");
        opdracht2();
        System.out.println("------------------------");
        opdracht3();
        System.out.println("------------------------");
        opdracht4();
        System.out.println("------------------------");
        opdracht5();

    }

    public static void opdracht1(){
        System.out.println("Opdracht 1: Tel 1 tot 10 met for-loop");
        for(int i = 1; i <= 10; i++){
            System.out.println(i);
            System.out.println();
        }
    }

    public static void opdracht2(){
        System.out.println("Opdracht 2: Tel 1 tot 10 met while-loop");
        int i = 0;
        while(i != 10){
            i++;
            System.out.println(i);
            System.out.println();
        }
    }

    public static void opdracht3(){
        System.out.println("Opdracht 3: Random getal tussen 0.0 en 1.0");
        System.out.println(Math.random());
        System.out.println();
    }

    public static void opdracht4(){
        System.out.println("Opdracht 4: Tel van 0 tot 39 en tel alles bij elkaar op");
        int antwoord = 0;
        for(int i = 0; i < 40; i++){
            antwoord += i;
        }
        System.out.println(antwoord);
        System.out.println();
    }

    public static void opdracht5(){
        System.out.println("Opdracht 5: Maak een zaagtant patroon met een if-statement en de letter s");
        for(int i = 0; i < 11; i++){
            if(i % 2 == 0){
                System.out.println("s");
            } else {
                System.out.println("ss");
            }
        }
        System.out.println();
    }
}
