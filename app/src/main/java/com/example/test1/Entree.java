package com.example.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.example.test1.adapters.ProduitAdapter2;
import java.util.ArrayList;


public class Entree extends AppCompatActivity {

    ArrayList<Produit> listEntreeF = new ArrayList<>();
    ArrayList<Produit> listEntreeC = new ArrayList<>();
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entree);

        db = new DatabaseHelper(getApplicationContext());

        listEntreeF = db.getProduit("entree", "froid");
        listEntreeC = db.getProduit("entree","chaud");

        ListView entreeFList = findViewById(R.id.listEntreeF);
        entreeFList.setAdapter(new ProduitAdapter2(this, listEntreeF));

        ListView entreeCList = findViewById(R.id.listEntreeC);
        entreeCList.setAdapter(new ProduitAdapter2(this, listEntreeC));

    }


}
