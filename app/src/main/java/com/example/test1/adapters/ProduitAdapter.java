package com.example.test1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.test1.Produit;
import com.example.test1.R;

import java.util.List;

public class ProduitAdapter extends BaseAdapter {
    private Context context;
    private List<Produit> produitList;
    private LayoutInflater inflater;

    public ProduitAdapter(Context context, List<Produit> produitList)
    {
        this.context = context;
        this.produitList = produitList;
        this.inflater = LayoutInflater.from(context);
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

        Produit currentItem = getItem(position);

        int id1 = currentItem.getId1();
        String nom = currentItem.getNom();
        String type = currentItem.getType();
        String temperature = currentItem.getTemperature();
        Float prix = currentItem.getPrix();



        TextView produitNameView = (TextView) view.findViewById(R.id.produitNom);
        produitNameView.setText(nom);

        TextView produitPriceView = (TextView) view.findViewById(R.id.produitPrix);
        produitPriceView.setText(""+prix);

        Button produitSupprimer = (Button) view.findViewById(R.id.produitSupp);


        return view;
    }
}
