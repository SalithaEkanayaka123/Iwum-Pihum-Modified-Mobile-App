package com.example.uee_recipe_management.application.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.category.ResponsiveVerticalHorizontalLayout;
import com.example.uee_recipe_management.application.home.Home;
import com.example.uee_recipe_management.application.temporary.TemporaryIndexPage;

public class OpeningSplashScreen extends AppCompatActivity {

    //Variables
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView heading, subheading;

    private static int SPLASH_SCREEN_TIMEOUT = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_opening_splash_screen);

        //Registering the Animation
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //Hooks
        image = findViewById(R.id.logo);
        heading = findViewById(R.id.title_header);
        subheading = findViewById(R.id.title_subheader);

        //Assigned the Animation.
        image.setAnimation(topAnim);
        heading.setAnimation(bottomAnim);
        subheading.setAnimation(bottomAnim);

        //Add the Intent trigger to navigate to the home activity.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(OpeningSplashScreen.this, Home.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN_TIMEOUT);

    }
}