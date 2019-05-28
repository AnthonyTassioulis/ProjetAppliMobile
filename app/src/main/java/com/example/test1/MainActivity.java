package com.example.test1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView accueil;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(getApplicationContext());

        db.insertCommande(4, 0.0);



            //Insertion des différents produits et menus
            db.insertProduit(1, "Gaspacho", 6.0, "chaud", "entree");
            db.insertProduit(2, "Soupe de carottes", 5.0, "chaud", "entree");
            db.insertProduit(3, "Tartare de saumon et d'avocats", 5.5, "froid", "entree");
            db.insertProduit(4, "Tartine de saumon fumé", 5.0, "froid", "entree");
            db.insertProduit(5, "Salade chèvre chaud", 6.5, "froid", "entree");

            db.insertProduit(6, "Lasagne à la bolognaise", 8.0, "chaud", "plat");
            db.insertProduit(7, "Sauté de veau au chorizo", 8.5, "chaud", "plat");
            db.insertProduit(8, "Salade de pâtes", 7.5, "froid", "plat");
            db.insertProduit(9, "Salade Caésar", 7.0, "froid", "plat");
            db.insertProduit(10, "Poulet à la moutarde", 9.0, "chaud", "plat");

            db.insertProduit(11, "Tiramisu", 4.0, "froid", "dessert");
            db.insertProduit(12, "Glace à la vanille", 3.5, "froid", "dessert");
            db.insertProduit(13, "Tarte pommes-poires", 4.0, "chaud", "dessert");
            db.insertProduit(14, "Sorbet au citron", 3.0, "froid", "dessert");
            db.insertProduit(15, "Cake au chocolat", 3.5, "chaud", "dessert");

            db.insertProduit(16, "Coca-cola", 4.0, "froid", "boisson");
            db.insertProduit(17, "Eau", 3.0, "froid", "boisson");
            db.insertProduit(18, "Thé froid", 3.5, "froid", "boisson");
            db.insertProduit(19, "Sprite", 4.0, "froid", "boisson");
            db.insertProduit(20, "Fanta", 4.0, "froid", "boisson");


        db.insertMenu(1, "Menu Caésar", "Tartine de saumon fumé", "Salade Caésar", "Sorbet au citron", 14.0);
        db.insertMenu(2, "Menu Poisson & Co.", "Tartare de saumon et d'avocats", "poulet à la moutarde", "Tiramisu", 17.0);
        db.insertMenu(3, "Menu italien", "gaspacho", "lasagne à la bolognaise", "Tiramisu", 16.0);


        db.closeDb();

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
