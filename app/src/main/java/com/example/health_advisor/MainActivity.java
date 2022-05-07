package com.example.health_advisor;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Define ActionBar object
        ActionBar actionBar;
        actionBar = getSupportActionBar();

        //prepare action bar apperance
        ColorDrawable colorDrawable= new ColorDrawable(Color.parseColor("#402C4F"));
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setIcon(R.drawable.ic_healthy);
        actionBar.setTitle("Categories");
        //get categories fragment
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        categorios_fragment f=new categorios_fragment();
        ft.replace(R.id.categories_fr_container,f);
        ft.commit();
    }
    //change menu to the menu that we had created

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menu_inflater=getMenuInflater();
        menu_inflater.inflate(R.menu.main_menu,menu);
        return true;
    }
}