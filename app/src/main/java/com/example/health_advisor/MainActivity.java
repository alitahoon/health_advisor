package com.example.health_advisor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView btn_main_favorite,btn_main_home,btn_main_profile;
    TextView main_txt,para_txt;
    Animation anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //assign all variable
        btn_main_favorite=findViewById(R.id.btn_main_favorite);
        btn_main_home=findViewById(R.id.btn_main_home);
        btn_main_profile=findViewById(R.id.btn_main_profile);
        main_txt=findViewById(R.id.main_text);
        para_txt=findViewById(R.id.para_text);
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
        //get favourite fragment
        btn_main_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //handle buttons style in pressed
                btn_main_favorite.setImageResource(R.drawable.ic_favorite_pressed);
                btn_main_profile.setImageResource(R.drawable.ic_profile);
                btn_main_home.setImageResource(R.drawable.ic_home);
                main_txt.setVisibility(View.GONE);
                para_txt.setVisibility(View.GONE);
                actionBar.setTitle("Favourites");
                //bring fragment
                FragmentManager fm= getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                //add animation to the fragment
                ft.setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right);
                non_empty_meal mef=new non_empty_meal();
                ft.replace(R.id.categories_fr_container,mef);
                ft.commit();
            }
        });
        //get Home fragment
        btn_main_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //handle buttons style in pressed
                btn_main_favorite.setImageResource(R.drawable.ic_favorite);
                btn_main_profile.setImageResource(R.drawable.ic_profile);
                btn_main_home.setImageResource(R.drawable.ic_home_pressed);
                main_txt.setVisibility(View.VISIBLE);
                para_txt.setVisibility(View.VISIBLE);
                //prepare text animation
                anim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scal);
                main_txt.startAnimation(anim);
                para_txt.setAnimation(anim);
                actionBar.setTitle("Categories");
                //bring fragment
                FragmentManager fm= getSupportFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
                categorios_fragment f=new categorios_fragment();
                ft.replace(R.id.categories_fr_container,f);
                ft.commit();
            }
        });
    }
    //change menu to the menu that we had created

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menu_inflater=getMenuInflater();
        menu_inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

}