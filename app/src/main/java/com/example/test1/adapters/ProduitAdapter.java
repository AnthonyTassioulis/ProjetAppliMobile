package com.example.test1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.test1.DatabaseHelper;
import com.example.test1.Produit;
import com.example.test1.R;

import java.util.List;

public class ProduitAdapter extends BaseAdapter {
    private Context context;
    private List<Produit> produitList;
    private LayoutInflater inflater;

    DatabaseHelper db;


    public ProduitAdapter(Context context, List<Produit> produitList)
    {
        this.context = context;
        this.produitList = produitList;
        this.inflater = LayoutInflater.from(context);

        db = new DatabaseHelper(context);
    }

    @Override
    public int getCount() {
        return produitList.size();
    }

    @Override
    public Produit getItem(int position) {
        return produitList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        view = inflater.inflate(R.layout.adapter_produit, null);

        final Produit currentItem = getItem(position);

        int id = currentItem.getId();
        String nom = currentItem.getNom();
        String type = currentItem.getType();
        String temperature = currentItem.getTemperature();
        Double prix = currentItem.getPrix();

        TextView produitIdView = (TextView) view.findViewById(R.id.idProduit);
        produitIdView.setText(String.valueOf(currentItem.getId()));

        TextView produitNameView = (TextView) view.findViewById(R.id.produitNom);
        produitNameView.setText(nom);

        TextView produitPriceView = (TextView) view.findViewById(R.id.produitPrix);
        produitPriceView.setText(String.valueOf(currentItem.getPrix())+"€");

        Button produitSupprimer = (Button) view.findViewById(R.id.produitSupp);

        produitSupprimer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                db.suppCommander(currentItem.getId());
            }
        });

        return view;
    }
}
