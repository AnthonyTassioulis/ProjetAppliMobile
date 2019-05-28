package com.example.test1;

public class MenuC {
    private int id;
    private String name;
    private String entree;
    private String plat;
    private String dessert;
    private Double prix;

    public MenuC(int id, String name,String entree, String plat, String dessert, Double prix)
    {
        this.id = id;
        this.name = name;
        this.entree = entree;
        this.plat = plat;
        this.dessert = dessert;
        this.prix = prix;
    }


    public int getId() {return id;}

    public String getName(){return name;}

    public String getEntree() {return entree;}

    public String getPlat(){return plat;}

    public String getDessert(){return dessert;}

    public Double getPrix(){return prix;}
}
