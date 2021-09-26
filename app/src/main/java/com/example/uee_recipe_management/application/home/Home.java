package com.example.uee_recipe_management.application.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.category.CategorySearchLayout;
import com.example.uee_recipe_management.application.notification.NotificationLayout;
import com.example.uee_recipe_management.application.settings.SettingPage;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView bottomNavView  = findViewById(R.id.bottom_nav);
        bottomNavView.setOnNavigationItemSelectedListener( navListener);
    }

    private  BottomNavigationView.OnNavigationItemSelectedListener navListener = new
            BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment selectedFragmnet =null;
                    switch (item.getItemId()){
                        case R.id.nav_home :
                            Intent intent = new Intent(Home.this, Home.class);
                            startActivity(intent);
                            break;
                        case R.id.nav_search :
                            Intent intent1 = new Intent(Home.this, CategorySearchLayout.class);
                            startActivity(intent1);
                            break;
                        case R.id.nav_add :
                            Intent intent2 = new Intent(Home.this, CategorySearchLayout.class);
                            startActivity(intent2);
                            break;
                        case R.id.nav_notification :
                            Intent intent3 = new Intent(Home.this, NotificationLayout.class);
                            startActivity(intent3);
                            break;
                        case R.id.nav_settings :
                            Intent intent4 = new Intent(Home.this, SettingPage.class);
                            startActivity(intent4);
                            break;
                    }
                    return true;
                }
            };
}