package com.example.health_advisor;

import static com.google.android.material.internal.ContextUtils.getActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.transition.TransitionManager;

import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.utils.Utils;

public class MainActivity extends AppCompatActivity implements categorios_fragment.onFragmentClicklistener{
    ImageView btn_main_favorite,btn_main_home,btn_main_profile;
    TextView main_txt,para_txt;
    LinearLayout main_footer,main_activity;
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
        main_footer=findViewById(R.id.main_footer);
        main_activity=findViewById(R.id.main_activity);
        // Define ActionBar object
        ActionBar actionBar;
        actionBar = getSupportActionBar();

        //prepare action bar apperance
        ColorDrawable colorDrawable= new ColorDrawable(Color.parseColor("#402C4F"));
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setIcon(R.drawable.ic_healthy);
        actionBar.setTitle("categories");
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
                //active them
                ColorDrawable colorDrawable1= new ColorDrawable(Color.parseColor("#C3AED6"));
                main_footer.setBackground(colorDrawable1);
                main_activity.setBackgroundColor(Color.parseColor("#C3AED6"));
                getSupportActionBar().setBackgroundDrawable(colorDrawable1);
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
                backHome();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            backHome();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();

//        if (searchView ==null)
//            Toast.makeText(this, "المشكله هناا ي زعييم", Toast.LENGTH_SHORT).show();

        searchView.setQueryHint("Type Food Name");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(MainActivity.this, newText+"...", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


    public void backHome(){
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
        getSupportActionBar().setTitle("Categories");
        //reset them
        ColorDrawable colorDrawable1= new ColorDrawable(Color.parseColor("#402C4F"));
        main_footer.setBackground(colorDrawable1);
        main_activity.setBackgroundColor(Color.parseColor("#402C4F"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#402C4F"));
        }
        //bring fragment
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
        categorios_fragment f=new categorios_fragment();
        ft.replace(R.id.categories_fr_container,f);
        ft.commit();
    }
    //change menu to the menu that we had created

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
    public void chanfeTitleOnActionbar(ActionBar actionBar,String title,String color){
        ColorDrawable colorDrawable= new ColorDrawable(Color.parseColor(color));
        actionBar.setTitle(title);
        actionBar.setBackgroundDrawable(colorDrawable);
        main_activity.setBackground(colorDrawable);
        main_footer.setBackground(colorDrawable);
    }

    @Override
    public void onFragmentItemClick(String Clickedcategorie) {
        switch (Clickedcategorie){
            case "diabits_categorie":
                FragmentManager fm= getSupportFragmentManager();
                getSupportActionBar().setTitle("Diabits Food");
                ColorDrawable colorDrawable1= new ColorDrawable(Color.parseColor("#B5EAEA"));
                main_footer.setBackground(colorDrawable1);
                main_activity.setBackgroundColor(Color.parseColor("#B5EAEA"));
                getSupportActionBar().setBackgroundDrawable(colorDrawable1);
                FragmentTransaction ft=fm.beginTransaction();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(Color.parseColor("#B5EAEA"));
                }
                ft.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
                ft.replace(R.id.categories_fr_container,container_content.newInstance("diabits_categorie",""));
                ft.commit();
                break;
            case "fitness_categorie":
                FragmentManager fmm= getSupportFragmentManager();
                getSupportActionBar().setTitle("Fitness Food");
                ColorDrawable colorDrawable2= new ColorDrawable(Color.parseColor("#C6EBC9"));
                main_footer.setBackground(colorDrawable2);
                main_activity.setBackgroundColor(Color.parseColor("#C6EBC9"));
                getSupportActionBar().setBackgroundDrawable(colorDrawable2);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(Color.parseColor("#C6EBC9"));
                }
                FragmentTransaction fft=fmm.beginTransaction();
                fft.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
                fft.replace(R.id.categories_fr_container,container_content.newInstance("fitness_categorie",""));
                fft.commit();
                break;
            case "diet_categorie":
                FragmentManager fmmm= getSupportFragmentManager();
                FragmentTransaction ffft=fmmm.beginTransaction();
                getSupportActionBar().setTitle("Diet Food");
                ColorDrawable colorDrawable3= new ColorDrawable(Color.parseColor("#BEDCFA"));
                main_footer.setBackground(colorDrawable3);
                main_activity.setBackgroundColor(Color.parseColor("#BEDCFA"));
                getSupportActionBar().setBackgroundDrawable(colorDrawable3);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(Color.parseColor("#BEDCFA"));
                }
                ffft.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
                ffft.replace(R.id.categories_fr_container,container_content.newInstance("diet_categorie",""));
                ffft.commit();
                break;
            case "hypertensive_categorie":
                FragmentManager fmmmm= getSupportFragmentManager();
                FragmentTransaction fffft=fmmmm.beginTransaction();
                getSupportActionBar().setTitle("Dypertensive Food");
                ColorDrawable colorDrawable4= new ColorDrawable(Color.parseColor("#FFBCBC"));
                main_footer.setBackground(colorDrawable4);
                main_activity.setBackgroundColor(Color.parseColor("#FFBCBC"));
                getSupportActionBar().setBackgroundDrawable(colorDrawable4);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(Color.parseColor("#FFBCBC"));
                }
                fffft.setCustomAnimations(R.anim.slide_in_right,R.anim.slide_out_left);
                fffft.replace(R.id.categories_fr_container,container_content.newInstance("hypertensive_categorie",""));
                fffft.commit();
                break;
        }
    }



    //change app them
//    public  void change_theme(String cat_name){
//        if (cat_name=="diabits_categorie"){
//            getSupportActionBar().setTitle("diabits_categorie");
//        }else if(cat_name=="fitness_categorie"){
//            getSupportActionBar().setTitle("fitness_categorie");
//        }else if(cat_name=="diet_categorie"){
//            getSupportActionBar().setTitle("diet_categorie");
//        }else if(cat_name=="hypertensive_categorie"){
//            getSupportActionBar().setTitle("hypertensive_categorie");
//        }
//    }
}