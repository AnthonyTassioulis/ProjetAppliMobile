package com.example.test1;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView accueil;
    private static final String DB_NAME = "App.db";
    private static final String TABLE_NAME1 = "produit";
    private static final String TABLE_NAME2= "menu";
    private static final String TABLE_NAME3 = "commande";
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME1 + "(id1 INTEGER PRIMARY KEY AUTOINCREMENT, " + "nom TEXT,type TEXT, temperature TEXT, prix FLOAT);");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME2 + "(id2 INTEGER PRIMARY KEY AUTOINCREMENT, " + "Entrée TEXT,plat TEXT, dessert TEXT, prix FLOAT);");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME3 + "(id3 INTEGER PRIMARY KEY AUTOINCREMENT, " + "numero TEXT, prix FLOAT);");

        db.close();


        this.accueil = (ImageView) findViewById(R.id.accueil);
        accueil.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(),MenuPrincipale.class);
                startActivity(otherActivity);
                finish();
            }
        });
    }
}
