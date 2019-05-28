package com.example.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Carte extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte);


    }

    public void goToEntree(View view)
    {
        Intent Entree = new Intent(Carte.this, Entree.class);
        startActivityForResult(Entree, 1);
    }

    public void goToPlat(View view)
    {
        Intent goToPlat = new Intent(Carte.this, Plat.class);
        startActivityForResult(goToPlat, 2);
    }

    public void goToDessert(View view)
    {
        Intent goToDessert = new Intent(Carte.this, Dessert.class);
        startActivityForResult(goToDessert, 3);
    }
}
