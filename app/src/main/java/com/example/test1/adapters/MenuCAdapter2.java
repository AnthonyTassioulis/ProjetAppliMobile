package com.example.test1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.test1.DatabaseHelper;
import com.example.test1.MenuC;
import com.example.test1.R;

import java.util.List;

public class MenuCAdapter2 extends BaseAdapter {
    private Context context;
    private List<MenuC> menuCList;
    private LayoutInflater inflater;

    DatabaseHelper db;


    public MenuCAdapter2(Context context, List<MenuC> menuCList)
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

        view = inflater.inflate(R.layout.adapter_menuc2, null);

        final MenuC currentItem = getItem(position);

        int id = currentItem.getId();
        String nom = currentItem.getName();
        Double prix = currentItem.getPrix();

        TextView menuIdView = (TextView) view.findViewById(R.id.idMenu2);
        menuIdView.setText(String.valueOf(currentItem.getId()));

        TextView menuNameView = (TextView) view.findViewById(R.id.menuNom2);
        menuNameView.setText(nom);

        TextView menuPriceView = (TextView) view.findViewById(R.id.menuPrix2);
        menuPriceView.setText(String.valueOf(currentItem.getPrix())+"€");

        Button menuAdd = view.findViewById(R.id.menuAdd);
        menuAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                db.insertCommanderM(db.getCommande(),currentItem.getId());
            }
        });


        return view;
    }
}
