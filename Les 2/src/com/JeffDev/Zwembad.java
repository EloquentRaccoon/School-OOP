package com.JeffDev;

public class Zwembad {
    double breedte;
    double lengte;
    double diepte;

    public Zwembad(){

    }
    public Zwembad(double breedte, double lengte, double diepte){
        setBreedte(breedte);
        setLengte(lengte);
        setDiepte(diepte);
    }

    public double inhoud(){
        double inhoud = this.lengte * this.breedte * this.diepte * 1000;
        return inhoud;
    }

    public String toString(){
        String info = this.breedte + " meter breedte, " + this.lengte + " meter lengte, " + this.diepte + " meter diepte.";
        return info;
    }

    //getters and setters
    //breedte
    public double getBreedte(){
        return this.breedte;
    }
    public void setBreedte(double breedte){
        this.breedte = breedte;
    }
    //lengte
    public double getLengte(){
        return this.lengte;
    }
    public void setLengte(double lengte){
        this.lengte = lengte;
    }
    //diepte
    public double getDiepte(){
        return this.diepte;
    }
    public void setDiepte(double diepte){
        this.diepte = diepte;
    }
}
