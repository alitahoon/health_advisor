package com.example.health_advisor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class splash extends AppCompatActivity {
    TextView app_name;
    ImageView app_logo;
    ImageView app_background;
    LottieAnimationView LAV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        app_name=findViewById(R.id.app_name_splash);
        app_background=findViewById(R.id.app_background_splash);
        app_logo=findViewById(R.id.app_logo_splash);
        LAV=findViewById(R.id.lotti_splash);
        app_name.animate().translationY(1600).setDuration(1000).setStartDelay(1500);
        app_background.animate().translationY(-1200).setDuration(1000).setStartDelay(1500);
        app_logo.animate().translationY(1600).setDuration(1000).setStartDelay(1500);
        LAV.animate().translationY(-1600).setDuration(1000).setStartDelay(1500);
//        Intent i =new Intent(getApplicationContext(),MainActivity.class);
//        startActivity(i);


    }
}