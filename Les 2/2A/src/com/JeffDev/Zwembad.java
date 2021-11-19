package com.JeffDev;

public class Zwembad {
    //zwembad values.
    private double breedte;
    private double lengte;
    private double diepte;

    //zwembad constructor, values from getters/setters.
    public Zwembad(){

    }
    //zwembad constructor, direct values.
    public Zwembad(double breedte, double lengte, double diepte){
        setBreedte(breedte);
        setLengte(lengte);
        setDiepte(diepte);
    }

    //Calculate inhoud value of zwembad.
    public double inhoud(){
        double inhoud = this.lengte * this.breedte * this.diepte * 1000;
        return inhoud;
    }

    //create string to get info about zwembad.
    public String toString(){
        String info = this.breedte + " meter breedte, " + this.lengte + " meter lengte, " + this.diepte + " meter diepte.";
        return info;
    }

    //getters and setters of zwembad values.
    //breedte.
    public double getBreedte(){
        return this.breedte;
    }
    public void setBreedte(double breedte){
        this.breedte = breedte;
    }
    //lengte.
    public double getLengte(){
        return this.lengte;
    }
    public void setLengte(double lengte){
        this.lengte = lengte;
    }
    //diepte.
    public double getDiepte(){
        return this.diepte;
    }
    public void setDiepte(double diepte){
        this.diepte = diepte;
    }
}
