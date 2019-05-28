package com.example.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.test1.adapters.ProduitAdapter2;

import java.util.ArrayList;

public class Dessert extends AppCompatActivity {


    ArrayList<Produit> listDessertF = new ArrayList<>();
    ArrayList<Produit> listDessertC = new ArrayList<>();
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);
        db = new DatabaseHelper(getApplicationContext());


        listDessertF = db.getProduit("dessert","froid");
        listDessertC = db.getProduit("dessert","chaud");


        ListView platFList = findViewById(R.id.listDessertF);
        platFList.setAdapter(new ProduitAdapter2(this, listDessertF));

        ListView DessertCList = findViewById(R.id.listDessertC);
        DessertCList.setAdapter(new ProduitAdapter2(this, listDessertC));
    }
}
