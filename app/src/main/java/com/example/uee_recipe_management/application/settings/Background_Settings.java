package com.example.uee_recipe_management.application.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    }
}