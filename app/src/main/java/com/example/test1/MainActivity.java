package com.example.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView accueil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
