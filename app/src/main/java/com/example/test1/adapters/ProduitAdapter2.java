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

public class ProduitAdapter2 extends BaseAdapter {

    private Context context;
    private List<Produit> produitList;
    private LayoutInflater inflater;

    DatabaseHelper db;


    public ProduitAdapter2(Context context, List<Produit> produitList)
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

        view = inflater.inflate(R.layout.adapter_produit2, parent, false);

        final Produit currentItem = getItem(position);


        TextView produitIdView = view.findViewById(R.id.idProduit2);
        produitIdView.setText(String.valueOf(currentItem.getId()));

        TextView produitNameView = view.findViewById(R.id.produitNom2);
        produitNameView.setText(currentItem.getNom());

        TextView produitPriceView = view.findViewById(R.id.produitPrix2);
        produitPriceView.setText(String.valueOf(currentItem.getPrix())+"€");

        Button produitAdd = view.findViewById(R.id.produitAdd);

        produitAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                db.insertCommander(db.getCommande(),currentItem.getId());
            }
        });

        return view;
    }
}
