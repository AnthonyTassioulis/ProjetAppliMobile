package com.example.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.example.test1.adapters.MenuCAdapter2;
import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    ArrayList<MenuC> listMenu = new ArrayList<>();

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        db = new DatabaseHelper(getApplicationContext());

        listMenu = db.getAllMenu();


        ListView menuList = findViewById(R.id.menu_list);
        menuList.setAdapter(new MenuCAdapter2(this, listMenu));


    }


}
