package com.example.test1;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {

    final private static int DATABASE_VERSION = 2;
    final private static String DATABASE_NAME = "database.db";

    final private static String TABLE_PRODUIT = "produit";
    final private static String PRODUIT_KEY = "idProduit";
    final private static String PRODUIT_NAME = "nomProduit";
    final private static String PRODUIT_PRICE = "prix";
    final private static String PRODUIT_TYPE = "type";
    final private static String PRODUIT_TEMPERATURE = "temperature";

    final private static String TABLE_MENU = "menu";
    final private static String MENU_KEY = "idMenu";
    final private static String MENU_NAME = "nomMenu";
    final private static String MENU_E = "entree";
    final private static String MENU_P = "plat";
    final private static String MENU_D = "dessert";
    final private static String MENU_PRICE = "prix";

    final private static String TABLE_COMMANDE = "commande";
    final private static String COMMANDE_KEY = "idCommande";
    final private static String COMMANDE_NUMERO_TABLE = "numero";
    final private static String COMMANDE_PRICE = "prix";

    final private static String TABLE_COMMANDER = "commander";

    final private static String TABLE_COMMANDER_M = "commanderM";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    final private static String CREATE_TABLE_PRODUIT = " CREATE TABLE " + TABLE_PRODUIT +
            "("
            + PRODUIT_KEY + " INTEGER PRIMARY KEY, "

            + PRODUIT_NAME + " TEXT, "

            + PRODUIT_PRICE + " DOUBLE, "

            + PRODUIT_TEMPERATURE + " TEXT, "

            + PRODUIT_TYPE + " TEXT "

            + ")";

    final private static String CREATE_TABLE_MENU = " CREATE TABLE " + TABLE_MENU +
            "("

            + MENU_KEY + " INTEGER PRIMARY KEY, "

            + MENU_NAME + " TEXT, "

            + MENU_E + " TEXT, "

            + MENU_P + " TEXT, "

            + MENU_D + " TEXT, "

            + MENU_PRICE + " DOUBLE "

            + ")";

    //requête permettant la création de la table
    final private static String CREATE_TABLE_COMMANDE = " CREATE TABLE " + TABLE_COMMANDE +

            "("

            + COMMANDE_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, "

            + COMMANDE_NUMERO_TABLE + " INTEGER, "

            + COMMANDE_PRICE + " DOUBLE "

            + ")";

    //Table qui joint les id de Produit et Commande
    private static final String CREATE_TABLE_COMMANDER = " CREATE TABLE " + TABLE_COMMANDER
            + "(" + COMMANDE_KEY + " INTEGER, "
            + PRODUIT_KEY + " INTEGER,"
            + " FOREIGN KEY (" + COMMANDE_KEY + ") "
            + " REFERENCES " + TABLE_COMMANDE + "(" + COMMANDE_KEY + "), "
            + " FOREIGN KEY (" + PRODUIT_KEY + ") "
            + " REFERENCES " + TABLE_PRODUIT + "(" + PRODUIT_KEY + ") "
            + ")";

    //Table qui joint les id de Menu et Commande
    private static final String CREATE_TABLE_COMMANDER_M = " CREATE TABLE " + TABLE_COMMANDER_M
            + "(" + COMMANDE_KEY + " INTEGER, "
            + MENU_KEY + " INTEGER,"
            + " FOREIGN KEY (" + COMMANDE_KEY + ") "
            + " REFERENCES " + TABLE_COMMANDE + "(" + COMMANDE_KEY + "), "
            + " FOREIGN KEY (" + MENU_KEY + ") "
            + " REFERENCES " + TABLE_MENU + "(" + MENU_KEY + ") "
            + ")";

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Execution des requêtes
        db.execSQL(CREATE_TABLE_PRODUIT);
        db.execSQL(CREATE_TABLE_MENU);
        db.execSQL(CREATE_TABLE_COMMANDE);
        db.execSQL(CREATE_TABLE_COMMANDER);
        db.execSQL(CREATE_TABLE_COMMANDER_M);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUIT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMANDE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMANDER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMANDER_M);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MENU);

        onCreate(db);
    }


    public void closeDb() {
        SQLiteDatabase db = this.getWritableDatabase();
        if (db != null && db.isOpen()) {
            db.close();
        }
    }

    public void insertCommande(int num, Double prix) {
        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "INSERT INTO " + TABLE_COMMANDE + "(" + COMMANDE_NUMERO_TABLE + "," + COMMANDE_PRICE
                +")" + " VALUES " + "(" + num + "," + prix + ")";

        db.execSQL(sql);
    }

    public long insertProduit (int id, String nom, Double prix, String temperature, String type)
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



    public long insertMenu (int id, String nom, String entree, String plat, String dessert, Double prix)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MENU_KEY, id);
        values.put(MENU_NAME, nom);
        values.put(MENU_E, entree);
        values.put(MENU_P, plat);
        values.put(MENU_D, dessert);
        values.put(MENU_PRICE, prix);
        long bool = db.insert(TABLE_MENU, null, values);
        return bool;
    }



    public ArrayList<Produit> getProduit(String t1, String t2) {

        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Produit> produitList = new ArrayList<>();


        String[] vals = {t1, t2};
        String selectQuery = "SELECT * FROM " + TABLE_PRODUIT + " WHERE " + PRODUIT_TYPE + " = ?" + " AND " + PRODUIT_TEMPERATURE + " = ?";
        Cursor req = db.rawQuery(selectQuery, vals);

        if(req != null && req.getCount()> 0) {
            while (req.moveToNext()) {
                produitList.add(new Produit(req.getInt(req.getColumnIndex(PRODUIT_KEY)), req.getString(req.getColumnIndex(PRODUIT_NAME)), req.getDouble(req.getColumnIndex(PRODUIT_PRICE)), req.getString(req.getColumnIndex(PRODUIT_TEMPERATURE)), req.getString(req.getColumnIndex(PRODUIT_TYPE))));

            }
        }

            return produitList;
    }

    public Double getProduitPrice(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Double price = 0.0;

        String query = " SELECT * FROM " + TABLE_PRODUIT + " INNER JOIN " + TABLE_COMMANDER + " ON " +
                TABLE_PRODUIT + "." + PRODUIT_KEY + " = " + TABLE_COMMANDER + "." + PRODUIT_KEY
                + " WHERE " + TABLE_COMMANDER + "." + COMMANDE_KEY + " = " + id;

        Cursor req = db.rawQuery(query, null);

        if(req != null && req.getCount()>0)
        {

            while(req.moveToNext())
            {
                price = price + req.getDouble(req.getColumnIndex(PRODUIT_PRICE));
            }
        }

        return price;

    }








    public ArrayList<MenuC> getAllMenu()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        ArrayList<MenuC> menuList = new ArrayList<>();

        String selectQuery = " SELECT * FROM " + TABLE_MENU;
        Cursor req = db.rawQuery(selectQuery, null);

        if(req != null && req.getCount()> 0) {
            while (req.moveToNext()) {
                menuList.add(new MenuC(req.getInt(req.getColumnIndex(MENU_KEY)), req.getString(req.getColumnIndex(MENU_NAME)), req.getString(req.getColumnIndex(MENU_E)), req.getString(req.getColumnIndex(MENU_P)), req.getString(req.getColumnIndex(MENU_D)), req.getDouble(req.getColumnIndex(MENU_PRICE))));

            }

        }
        return menuList;
    }

    public Double getMenuPrice(int id)
    {
        Double price = 0.0;
        SQLiteDatabase db = this.getReadableDatabase();

        String query = " SELECT * FROM " + TABLE_MENU + " INNER JOIN " + TABLE_COMMANDER_M + " ON " +
                TABLE_MENU + "." + MENU_KEY + " = " + TABLE_COMMANDER_M + "." + MENU_KEY
                + " WHERE " + TABLE_COMMANDER_M + "." + COMMANDE_KEY + " = " + id;

        Cursor req = db.rawQuery(query, null);

        if(req != null && req.getCount()>0)
        {

            while(req.moveToNext())
            {
                price = price + req.getDouble(req.getColumnIndex(MENU_PRICE));
            }
        }

        return price;
    }


    public int getCommande()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        int idCommande = 1;
        String Query = "SELECT " + COMMANDE_KEY + " FROM " + TABLE_COMMANDE + " ORDER BY " + COMMANDE_KEY;
        Cursor c = db.rawQuery(Query, null);

        if (c != null && c.getCount() > 0) {

            while(c.moveToNext())
            {
                idCommande = c.getInt(c.getColumnIndex(COMMANDE_KEY));
            }

        }

        return idCommande;
    }

    public void suppCommander(int id1)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String Query = "DELETE FROM " + TABLE_COMMANDER + "WHERE " + PRODUIT_KEY + "=" + id1;
        db.execSQL(Query);
    }

    public void suppCommanderM(int id1)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String Query = "DELETE FROM " + TABLE_COMMANDER_M + " WHERE " + MENU_KEY + "=" + id1;
        db.execSQL(Query);
    }

    public long insertCommander(int id1, int id2)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COMMANDE_KEY, id1);
        values.put(PRODUIT_KEY, id2);
        long bool = db.insert(TABLE_COMMANDER, null, values);
        return bool;
    }


    public long insertCommanderM(int id1, int id2)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COMMANDE_KEY, id1);
        values.put(MENU_KEY, id2);
        long bool = db.insert(TABLE_COMMANDER_M, null, values);
        return bool;
    }


    public ArrayList<Produit> getCommander(int id)
    {
        ArrayList<Produit> commandeList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = " SELECT * FROM " + TABLE_PRODUIT + " INNER JOIN " + TABLE_COMMANDER + " ON " +
                TABLE_PRODUIT + "." + PRODUIT_KEY + " = " + TABLE_COMMANDER + "." + PRODUIT_KEY
                + " WHERE " + TABLE_COMMANDER + "." + COMMANDE_KEY + " = " + id;

        Cursor req = db.rawQuery(query, null);

        if(req != null && req.getCount()>0)
        {
            while(req.moveToNext())
            {
                commandeList.add(new Produit(req.getInt(req.getColumnIndex(PRODUIT_KEY)), req.getString(req.getColumnIndex(PRODUIT_NAME)), req.getDouble(req.getColumnIndex(PRODUIT_PRICE)), req.getString(req.getColumnIndex(PRODUIT_TEMPERATURE)), req.getString(req.getColumnIndex(PRODUIT_TYPE))));
            }
        }

        return commandeList;
    }

    public ArrayList<MenuC> getCommanderM(int id)
    {
        ArrayList<MenuC> commandeList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query = " SELECT * FROM " + TABLE_MENU + " INNER JOIN " + TABLE_COMMANDER_M + " ON " +
                TABLE_MENU + "." + MENU_KEY + " = " + TABLE_COMMANDER_M + "." + MENU_KEY
                + " WHERE " + TABLE_COMMANDER_M + "." + COMMANDE_KEY + " = " + id;

        Cursor req = db.rawQuery(query, null);

        if(req != null && req.getCount()>0)
        {
            while(req.moveToNext())
            {
                commandeList.add(new MenuC(req.getInt(req.getColumnIndex(MENU_KEY)), req.getString(req.getColumnIndex(MENU_NAME)), req.getString(req.getColumnIndex(MENU_E)), req.getString(req.getColumnIndex(MENU_P)), req.getString(req.getColumnIndex(MENU_D)), req.getDouble(req.getColumnIndex(MENU_PRICE))));
            }
        }

        return commandeList;
    }


}
