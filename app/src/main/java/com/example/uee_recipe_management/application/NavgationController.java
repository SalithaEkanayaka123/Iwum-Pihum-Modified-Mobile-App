package com.example.uee_recipe_management.application;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.uee_recipe_management.application.category.CategorySearchLayout;
import com.example.uee_recipe_management.application.home.Home;
import com.example.uee_recipe_management.application.notification.NotificationLayout;
import com.example.uee_recipe_management.application.settings.SettingPage;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavgationController extends AppCompatActivity {

  protected boolean ChangeMainAcivty (MenuItem item, Context currentIntent ) {
                    switch (item.getItemId()){
                        case R.id.nav_home :
                            Intent intent = new Intent(currentIntent, Home.class);
                            startActivity(intent);
                            break;
                        case R.id.nav_search :
                            Intent intent1 = new Intent(currentIntent, CategorySearchLayout.class);
                            startActivity(intent1);
                            break;
                        case R.id.nav_add :
                            Intent intent2 = new Intent(currentIntent, CategorySearchLayout.class);
                            startActivity(intent2);
                            break;
                        case R.id.nav_notification :
                            Intent intent3 = new Intent(currentIntent, NotificationLayout.class);
                            startActivity(intent3);
                            break;
                        case R.id.nav_settings :
                            Intent intent4 = new Intent(currentIntent, SettingPage.class);
                            startActivity(intent4);
                            break;
                    }
                    return true;
                }
            }
