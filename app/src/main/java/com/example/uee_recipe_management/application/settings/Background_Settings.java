package com.example.uee_recipe_management.application.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings2;
import com.example.uee_recipe_management.application.settings.model.customButton1;

import java.util.ArrayList;

public class Background_Settings extends AppCompatActivity {

    ListView listView1, listView2;
    CustomButtonSettings adapter;
    CustomButtonSettings2 adapter2;//declaring the Custom adapter
    ArrayList<customButton1> array, array2;//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background__settings);

        listView1 = (ListView) findViewById(R.id.listSettings6);
        listView2 = (ListView) findViewById(R.id.listSettings7);

        array = new ArrayList<>();
        array.add(new customButton1("Dark Mode", "Enable Dark Mode", true));

        array2 = new ArrayList<>();
        array2.add(new customButton1("Display Language", "Choose a language", true));
        array2.add(new customButton1("Switch Layout", "Change the layouts of interface", true));
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
//                    Intent intent  = new Intent(view.getContext(), Notification_Settings.class);
//                    view.getContext().startActivity(intent);
                }else if (i == 2){
                    SortBy settingsFragment = new SortBy();
                    settingsFragment.show(getSupportFragmentManager(),"myFragment");
                }
            }
        });
    }
}