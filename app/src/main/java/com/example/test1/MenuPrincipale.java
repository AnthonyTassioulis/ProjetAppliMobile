package com.example.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MenuPrincipale extends AppCompatActivity {

    private Button menu;
    private Button carte;
    private Button boissons;

    private TextView commande;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principale);


    }

    public void goToMenu(View view)
    {
        Intent Menu = new Intent(MenuPrincipale.this, Menu.class);
        startActivityForResult(Menu, 1);
    }
    public void goToCarte(View view)
    {
        Intent Carte = new Intent(MenuPrincipale.this, Carte.class);
        startActivityForResult(Carte, 2);
    }
    public void goToBoisson(View view)
    {
        Intent Boisson = new Intent(MenuPrincipale.this, Boisson.class);
        startActivityForResult(Boisson, 3);
    }
    public void goToCommande(View view)
    {
        Intent Commande = new Intent(MenuPrincipale.this, Commande.class);
        startActivityForResult(Commande, 4);
    }
}
