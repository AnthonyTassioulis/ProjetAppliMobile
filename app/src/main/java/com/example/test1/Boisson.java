package com.example.test1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.test1.adapters.ProduitAdapter2;

import java.util.ArrayList;

public class Boisson extends AppCompatActivity {


    ArrayList<Produit> listBoisson = new ArrayList<>();

    DatabaseHelper db;
    private Button commande;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boisson);



        db = new DatabaseHelper(getApplicationContext());

        listBoisson = db.getProduit("boisson", "froid");


        ListView boissonList = findViewById(R.id.boisson_list);
        boissonList.setAdapter(new ProduitAdapter2(this, listBoisson));




    }


}
