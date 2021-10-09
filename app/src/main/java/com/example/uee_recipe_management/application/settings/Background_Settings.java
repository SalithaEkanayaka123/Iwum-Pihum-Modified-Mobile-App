package com.example.uee_recipe_management.application.settings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.uee_recipe_management.application.NavgationController;
import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.home.Home;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings2;
import com.example.uee_recipe_management.application.settings.model.customButton1;
import com.example.uee_recipe_management.application.settings.SettingPage;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Background_Settings extends AppCompatActivity {

    ListView listView1, listView2;
    CustomButtonSettings adapter;
    CustomButtonSettings2 adapter2;//declaring the Custom adapter
    ArrayList<customButton1> array, array2;//

//    ///////////Navigation
//    NavgationController Nav = new NavgationController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background__settings);


//        //////////////
//        BottomNavigationView bottomNavView  = findViewById(R.id.bottom_nav);
//        bottomNavView.setOnNavigationItemSelectedListener( navListener);
//
//        Menu menu = bottomNavView.getMenu();
//        MenuItem menuItem = menu.getItem(4);
//        menuItem.setChecked(true);
//        //////////////

        listView1 = (ListView) findViewById(R.id.listSettings6);
        listView2 = (ListView) findViewById(R.id.listSettings7);

        array = new ArrayList<>();
        array.add(new customButton1(getString(R.string.DarkMode), getString(R.string.EnableDarkMode), true));

        array2 = new ArrayList<>();
        array2.add(new customButton1(getString(R.string.DisplayLanguage), getString(R.string.Choosealanguage), true));
        array2.add(new customButton1(getString(R.string.SwitchLayout), getString(R.string.Changethelayoutsofinterface), true));
        array2.add(new customButton1("Sort By", "sort by", true));


        adapter = new CustomButtonSettings(this , array);//this is called in customMusicAdapter
        adapter2 = new CustomButtonSettings2(this , array2);//
        //then set that adapter to the listView
        listView1.setAdapter(adapter);
        listView2.setAdapter(adapter2);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    DisplayLanguage settingsFragment = new DisplayLanguage();
                    settingsFragment.show(getSupportFragmentManager(),"myFragment");
                }else if (i == 1){
                    LayoutFragment settingsFragment = new LayoutFragment();
                    settingsFragment.show(getSupportFragmentManager(),"myFragment");
                }else if (i == 2){
                    SortBy settingsFragment = new SortBy();
                    settingsFragment.show(getSupportFragmentManager(),"myFragment");
                }
            }
        });
    }

//    private  BottomNavigationView.OnNavigationItemSelectedListener navListener = new
//            BottomNavigationView.OnNavigationItemSelectedListener(){
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    Intent change =  Nav.ChangeMainAcivty(item, SettingPage);
//                    startActivity(change);
//                    return true;
//                }
//            };
}