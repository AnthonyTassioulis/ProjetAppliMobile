package com.example.test1;

public class CommandeC {

    private int id;
    private int num;
    private Double prix;

    public CommandeC(int id, int num, Double prix)
    {
        this.id = id;
        this.num = num;
        this.prix = prix;
    }


    public int getId(){return id;}

    public int getNum(){return num;}

    public Double getPrix(){return prix;}
}
