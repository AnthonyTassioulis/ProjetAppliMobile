package com.example.test1.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.test1.Commande;
import com.example.test1.DatabaseHelper;
import com.example.test1.MenuC;
import com.example.test1.MenuPrincipale;
import com.example.test1.R;

import java.util.List;

public class MenuCAdapter extends BaseAdapter {
    private Context context;
    private List<MenuC> menuCList;
    private LayoutInflater inflater;

    DatabaseHelper db;



    public MenuCAdapter(Context context, List<MenuC> menuCList)
    {
        this.context = context;
        this.menuCList = menuCList;
        this.inflater = LayoutInflater.from(context);

        db = new DatabaseHelper(context);

    }

    @Override
    public int getCount() {
        return menuCList.size();
    }

    @Override
    public MenuC getItem(int position) {
        return menuCList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view = inflater.inflate(R.layout.adapter_menuc, null);

        final MenuC currentItem = getItem(position);
        int id = currentItem.getId();
        String nom = currentItem.getName();
        Double prix = currentItem.getPrix();

        TextView menuIdView = (TextView) view.findViewById(R.id.idMenu);
        menuIdView.setText(String.valueOf(currentItem.getId()));

        TextView menuNameView = (TextView) view.findViewById(R.id.menuNom);
        menuNameView.setText(nom);

        TextView menuPriceView = (TextView) view.findViewById(R.id.menuPrix);
        menuPriceView.setText(String.valueOf(currentItem.getPrix())+"€");

        Button menuSupprimer = (Button) view.findViewById(R.id.menuSupp);

        menuSupprimer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                db.suppCommanderM(currentItem.getId());

            }
        });


        return view;
    }
}