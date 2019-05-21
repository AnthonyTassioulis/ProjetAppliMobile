package com.example.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MenuPrincipale extends AppCompatActivity {

    private Button menu;
    private Button carte;
    private Button boissons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principale);

        this.menu = (Button) findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(),Menu.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.carte = (Button) findViewById(R.id.carte);
        carte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),Carte.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.boissons = findViewById(R.id.boissons);
        boissons.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent otherActivity = new Intent (getApplicationContext(), Boisson.class);
                startActivity(otherActivity);
                finish();

            }
        });
    }
}
