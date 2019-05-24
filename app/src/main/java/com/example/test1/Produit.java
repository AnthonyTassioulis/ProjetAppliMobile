package com.example.test1;

public class Produit {

    private int id1;
    private String nom;
    private String type;
    private String temperature;
    private Float prix;

public Produit(int id1,String nom, String type, String temperature, Float prix){

    this.id1 = id1;
    this.nom = nom;
    this.type = type;
    this.temperature = temperature;
    this.prix = prix;
}
public int getId1() {return id1;}

public String getNom(){return nom;}

public String getType() {return type;}

public String getTemperature() {return temperature;}

public Float getPrix(){return prix;}
}
