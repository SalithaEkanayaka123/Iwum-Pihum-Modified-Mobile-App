package com.example.uee_recipe_management.application.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.home.fragments.AddItemFragment;
import com.example.uee_recipe_management.application.home.fragments.HomeFragment;
import com.example.uee_recipe_management.application.home.fragments.SettingsFragment;
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
                            selectedFragmnet = new HomeFragment();
                            break;
                        case R.id.nav_search :
                            selectedFragmnet = new HomeFragment();
                            break;
                        case R.id.nav_add :
                            selectedFragmnet = new AddItemFragment();
                            break;
                        case R.id.nav_notification :
                            selectedFragmnet = new HomeFragment();
                            break;
                        case R.id.nav_settings :
                            selectedFragmnet = new SettingsFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragmnet).commit();

                    return true;
                }
            };
}