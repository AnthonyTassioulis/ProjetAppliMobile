package com.example.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Carte extends AppCompatActivity {

    private Button commande;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte);

        this.commande = findViewById(R.id.commande);
        commande.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent otherActivity = new Intent (getApplicationContext(), Commande.class);
                startActivity(otherActivity);
                finish();

            }
        });
    }
}
