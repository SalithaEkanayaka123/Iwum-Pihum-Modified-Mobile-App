package com.example.uee_recipe_management.application.settings;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.uee_recipe_management.application.NavgationController;
import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.category.CategorySearchLayout;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings2;
import com.example.uee_recipe_management.application.settings.model.customButton1;
import com.example.uee_recipe_management.application.splash.OpeningSplashScreen;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class SettingPage extends AppCompatActivity {

    ListView listView1;
    CustomButtonSettings2 adapter2;//declaring the Custom adapter
    ArrayList<customButton1> array;
    AppCompatTextView appCompatTextView;
    //CardView cardView;
    NavgationController Nav = new NavgationController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_page);

        //Bottom Nav Configs
        BottomNavigationView bottomNavView  = findViewById(R.id.bottom_nav);
        appCompatTextView = (AppCompatTextView) findViewById(R.id.category_header);
        bottomNavView.setOnNavigationItemSelectedListener( navListener);
        Menu menu = bottomNavView.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);



        listView1 = (ListView) findViewById(R.id.listSettings8);
        //cardView = (CardView) findViewById(R.id.custombuttonsettings2);
        array = new ArrayList<>();
        array.add(new customButton1(getString(R.string.Background), getString(R.string.HandlesBackgroundSettings), true));
        array.add(new customButton1(getString(R.string.Notification), getString(R.string.HandlesNotificationSettings), true));
        array.add(new customButton1(getString(R.string.Synchronization), getString(R.string.HandlesSynchronizationSettings), true));
        array.add(new customButton1(getString(R.string.PrivacyandPolicy), getString(R.string.PrivacyandPolicy), true));
        array.add(new customButton1(getString(R.string.about), getString(R.string.about), true));

        adapter2 = new CustomButtonSettings2(this , array);//
        //then set that adapter to the list
        listView1.setAdapter(adapter2);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 0){
                    System.out.println("calling");
//                    Intent intent  = new Intent(view.getContext(), Background_Settings.class);
//                    view.getContext().startActivity(intent);
                    appCompatTextView.setText(R.string.Background);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new Background_Settings_Fragment()).commit();

//                    Background_Settings_Fragment fr = getFragmentManager().beginTransaction();
//                    fr.add(R.id.container,new DisplayLanguage());
//                    fr.commit();
                }else if (i == 1){
                    //cardView.setBackgroundColor(Color.parseColor("#9F897D"));
                    appCompatTextView.setText(R.string.Notification);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new Notification_Settings_Fragment()).commit();
//                    Intent intent  = new Intent(view.getContext(), Notification_Settings.class);
//                    view.getContext().startActivity(intent);
                }else if (i == 2){
                    Synchronization settingsFragment = new Synchronization();
                    settingsFragment.show(getSupportFragmentManager(),"myFragment");
//                    System.out.println("ww1");
//
//                    System.out.println("ww2");
//                    FragmentManager fragmentManager = getSupportFragmentManager();
//                    System.out.println("ww3");
//                    fragmentManager.beginTransaction().add(R.id.settingsMainPage , settingsFragment).commit();
                }else if (i == 3){
                    appCompatTextView.setText(R.string.PrivacyandPolicy);
//                    Intent intent  = new Intent(view.getContext(), PrivacyAndPolicy_Settings.class);
//                    view.getContext().startActivity(intent);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new PrivacyAndPolicy_Settings_Fragment()).commit();
                }else if (i == 4){
                    About settingsFragment = new About();
                    settingsFragment.show(getSupportFragmentManager(),"myFragment1");
                }
            }
        });
    }

    private  BottomNavigationView.OnNavigationItemSelectedListener navListener = new
            BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Intent change =  Nav.ChangeMainAcivty(item, SettingPage.this);
                    startActivity(change);
                    return true;
                }
            };
}