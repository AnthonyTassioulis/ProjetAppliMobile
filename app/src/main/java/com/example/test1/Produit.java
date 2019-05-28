package com.example.test1;

public class Produit {

    private int id;
    private String nom;
    private Double prix;
    private String temperature;
    private String type;


public Produit(int id,String nom, Double prix, String temperature, String type){

    this.id = id;
    this.nom = nom;
    this.prix = prix;
    this.temperature = temperature;
    this.type = type;


}
public int getId() {return id;}

public String getNom(){return nom;}

public Double getPrix(){return prix;}

public String getTemperature() {return temperature;}

public String getType() {return type;}
}
