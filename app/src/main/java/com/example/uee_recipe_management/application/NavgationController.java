package com.example.uee_recipe_management.application;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uee_recipe_management.application.category.CategorySearchLayout;
import com.example.uee_recipe_management.application.category.ResponsiveLayout;
import com.example.uee_recipe_management.application.category.ResponsiveVerticalHorizontalLayout;
import com.example.uee_recipe_management.application.home.Home;
import com.example.uee_recipe_management.application.notification.NotificationLayout;
import com.example.uee_recipe_management.application.settings.SettingPage;

public class NavgationController extends AppCompatActivity {

  public Intent ChangeMainAcivty(MenuItem item, Context currentIntent) {
                    switch (item.getItemId()){
                        case R.id.nav_home :
                            Intent intent = new Intent(currentIntent, Home.class);
                            return intent;
                        case R.id.nav_search :
                            Intent intent1 = new Intent(currentIntent, ResponsiveVerticalHorizontalLayout.class);
                            return intent1;
                        case R.id.nav_add :
                            Intent intent2 = new Intent(currentIntent, null);
                            return intent2;
                        case R.id.nav_notification :
                            Intent intent3 = new Intent(currentIntent, NotificationLayout.class);
                            return intent3;
                        case R.id.nav_settings :
                            Intent intent4 = new Intent(currentIntent, SettingPage.class);
                            return intent4;

                    }
      return null;
  }
}
