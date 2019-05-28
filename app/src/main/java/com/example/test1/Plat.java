package com.example.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.test1.adapters.ProduitAdapter2;

import java.util.ArrayList;

public class Plat extends AppCompatActivity {

    ArrayList<Produit> listPlatF = new ArrayList<>();
    ArrayList<Produit> listPlatC = new ArrayList<>();
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plat);


        db = new DatabaseHelper(getApplicationContext());


        listPlatF = db.getProduit("plat","froid");
        listPlatC = db.getProduit("plat","chaud");


        ListView platFList = findViewById(R.id.listPlatF);
        platFList.setAdapter(new ProduitAdapter2(this, listPlatF));

        ListView platCList = findViewById(R.id.listPlatC);
        platCList.setAdapter(new ProduitAdapter2(this, listPlatC));
    }
}
