package com.example.uee_recipe_management.application.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.uee_recipe_management.application.CustomButtonSettings.CustomButtonSettings;
import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.category.model.FoodItemModel;
import com.example.uee_recipe_management.application.settings.model.customButton1;

import java.util.ArrayList;

public class Testing1 extends AppCompatActivity {

    ListView listView1, listView2;
    CustomButtonSettings adapter;//declaring the Custom adapter
    ArrayList<customButton1> array;//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing2);

        listView1 = (ListView) findViewById(R.id.listSettings1);
        listView2 = (ListView) findViewById(R.id.listSettings2);

        array = new ArrayList<>();
        array.add(new customButton1("background1", "background2", true));
        array.add(new customButton1("background1", "background2", true));
        array.add(new customButton1("background1", "background2", true));

        adapter = new CustomButtonSettings(this , array);//this is called in customMusicAdapter
        //then set that adapter to the listView
        listView1.setAdapter(adapter);
        //mentioning to update the rows
        adapter.notifyDataSetChanged();
    }
}