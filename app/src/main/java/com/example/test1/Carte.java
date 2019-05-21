package com.example.test1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Carte extends AppCompatActivity {

    private Button commande;
    private SQLiteDatabase db;
    private Cursor req;

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

                db = openOrCreateDatabase("App.db", MODE_PRIVATE,null);
                req = db.rawQuery("SELECT * FROM Tache ORDER BY type", null);


                List<Element> elementList = new ArrayList<>();

                if(req != null && req.getCount()>0)

                {
                    while(req.moveToNext())
                    {
                        elementList.add(new Element(req.getInt(req.getColumnIndex("id")),req.getString(req.getColumnIndex("actions")),req.getString(req.getColumnIndex("date")),req.getString(req.getColumnIndex("duree"))));
                    }

                    db.close();
                    ListView elementListView = findViewById(R.id.carte_list);
                    elementListView.setAdapter(new ElementAdapter(this, elementList));

                }




                db.close();


            }
        });
    }
}
