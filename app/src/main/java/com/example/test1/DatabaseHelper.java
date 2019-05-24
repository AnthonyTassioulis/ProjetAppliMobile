package com.example.test1;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {


    final private static int DATABASE_VERSION = 1;
    final private static String DATABASE_NAME = "db1.db";

    final private static String TABLE_PRODUIT = "produit";
    final private static String PRODUIT_KEY = "idProduit";
    final private static String PRODUIT_NAME = "nom";
    final private static String PRODUIT_PRICE = "prix";
    final private static String PRODUIT_TYPE = "type";
    final private static String PRODUIT_TEMPERATURE = "temperature";

    final private static String TABLE_MENU = "menu";
    final private static String MENU_KEY = "idMenu";
    final private static String MENU_E = "entree";
    final private static String MENU_P = "plat";
    final private static String MENU_D = "dessert";
    final private static String MENU_PRICE = "prix";

    final private static String TABLE_COMMANDE = "commande";
    final private static String COMMANDE_KEY = "idCommande";
    final private static String COMMANDE_NUMERO_TABLE = "numero";
    final private static String COMMANDE_PRICE = "prix";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    final private static String CREATE_TABLE_PRODUIT = "CREATE TABLE " + TABLE_PRODUIT +
            "("
            + PRODUIT_KEY + "INTEGER PRIMARY KEY AUTOINCREMENT, "

            + PRODUIT_NAME + "TEXT, "

            + PRODUIT_PRICE + "REAL, "

            + PRODUIT_TEMPERATURE + "TEXT, "

            + PRODUIT_TYPE + ("TEXT")

            + ")";

    final private static String CREATE_TABLE_MENU = "CREATE TABLE " + TABLE_MENU +
            "("

            + MENU_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, "

            + MENU_E + "TEXT, "

            + MENU_P + "TEXT, "

            +MENU_D + "TEXT, "

            +MENU_PRICE + "REAL"

            + ")";

    final private static String CREATE_TABLE_COMMANDE = "CREATE TABLE " + TABLE_COMMANDE +

            "("

            + COMMANDE_KEY + "INTEGER PRIMARY KEY AUTOINCREMENT, "

            + COMMANDE_NUMERO_TABLE + "INTEGER, "

            + COMMANDE_PRICE + "REAL, "

            + "FOREIGN KEY (" + PRODUIT_KEY + ") "

            + "REFERENCES " + TABLE_PRODUIT + "(" + PRODUIT_KEY + ") "

            + ")";

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_PRODUIT);
        db.execSQL(CREATE_TABLE_MENU);
        db.execSQL(CREATE_TABLE_COMMANDE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUIT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMANDE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MENU);
        // create new tables
        onCreate(db);
    }

    public void closeDb() {
        SQLiteDatabase db = this.getWritableDatabase();
        if (db != null && db.isOpen()) {
            db.close();
        }
    }

    public long insertCommande(int numero, Float prix, int produit) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COMMANDE_NUMERO_TABLE, numero);
        values.put(COMMANDE_PRICE, prix);
        values.put(PRODUIT_KEY, produit);
        long bool = db.insert(TABLE_COMMANDE, null, values);
        return bool;
    }

    public long insertProduit (int id, String nom, Float prix, String temperature, String type)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PRODUIT_KEY, id);
        values.put(PRODUIT_NAME, nom);
        values.put(PRODUIT_PRICE, prix);
        values.put(PRODUIT_TEMPERATURE, temperature);
        values.put(PRODUIT_TYPE, type);
        long bool = db.insert(TABLE_PRODUIT, null, values);
        return bool;
    }

    public long insertMenu (int id, String entree, String plat, String dessert, Float prix)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PRODUIT_KEY, id);
        values.put(MENU_E, entree);
        values.put(MENU_P, plat);
        values.put(MENU_D, dessert);
        values.put(MENU_PRICE, prix);
        long bool = db.insert(TABLE_MENU, null, values);
        return bool;
    }

    public List<Produit> getProduit(String type, String temperature) {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Produit> produitList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PRODUIT + "WHERE" + PRODUIT_TYPE + "="+ type + "WHERE" + PRODUIT_TEMPERATURE + "=" + temperature;
        Cursor req = db.rawQuery(selectQuery, null);
        if(req != null && req.getCount()> 0) {
            while (req.moveToNext()) {
                produitList.add(new Produit(req.getInt(req.getColumnIndex("id")), req.getString(req.getColumnIndex("nom")), req.getString(req.getColumnIndex("type")), req.getString(req.getColumnIndex("temperature")), req.getFloat(req.getColumnIndex("prix"))));

            }

        }
            return produitList;
    }
}
