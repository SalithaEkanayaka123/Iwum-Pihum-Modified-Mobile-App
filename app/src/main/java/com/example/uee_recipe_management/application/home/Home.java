package com.example.uee_recipe_management.application.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.uee_recipe_management.application.NavgationController;
import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.category.CategorySearchLayout;
import com.example.uee_recipe_management.application.notification.NotificationLayout;
import com.example.uee_recipe_management.application.settings.SettingPage;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    NavgationController Nav = new NavgationController();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView bottomNavView  = findViewById(R.id.bottom_nav);
        bottomNavView.setOnNavigationItemSelectedListener( navListener);

        Menu menu = bottomNavView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
    }

    private  BottomNavigationView.OnNavigationItemSelectedListener navListener = new
            BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                   Intent change =  Nav.ChangeMainAcivty(item, Home.this);
                    startActivity(change);
                    return true;
                }
    };
}