package com.example.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.test1.adapters.MenuCAdapter;
import com.example.test1.adapters.ProduitAdapter;

import java.util.ArrayList;
import java.util.List;

public class Commande extends AppCompatActivity {

    ArrayList<Produit> produitList = new ArrayList<>();

    ArrayList<MenuC> menuList = new ArrayList<>();

    Double price;

    DatabaseHelper db;

private String destinataire = "flo.duboquet@gmail.com";
private String sujet = "commande table 4";
private String textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commande);


        db = new DatabaseHelper(getApplicationContext());

        produitList = db.getCommander(db.getCommande());

        ListView Produits = findViewById(R.id.commande_produits);
        Produits.setAdapter(new ProduitAdapter(this, produitList));

        menuList = db.getCommanderM(db.getCommande());

        ListView Menus = findViewById(R.id.commande_menus);
        Menus.setAdapter(new MenuCAdapter(this, menuList));


        price = db.getProduitPrice(db.getCommande()) + db.getMenuPrice(db.getCommande());

        TextView prix = findViewById(R.id.prix);
        prix.setText("Total : " + price + "€");

    }

    public void passerCommande(View view)
    {

        Sendmail();
    }

    private void Sendmail (){

        textMessage = ;
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,destinataire);
        intent.putExtra(Intent.EXTRA_SUBJECT,sujet);
        intent.putExtra(Intent.EXTRA_TEXT,textMessage);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "please choose Gmail"));

    }

}
