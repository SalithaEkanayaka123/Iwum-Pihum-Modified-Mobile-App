package com.example.uee_recipe_management.application.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.uee_recipe_management.application.CustomButtonSettings.CustomButtonSettings;
import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.category.model.FoodItemModel;
import com.example.uee_recipe_management.application.settings.model.customButton1;

import java.util.ArrayList;

public class Testing1 extends AppCompatActivity {

    ListView listView1, listView2;
    CustomButtonSettings adapter, adapter2;//declaring the Custom adapter
    ArrayList<customButton1> array, array2;//
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

        array2 = new ArrayList<>();
        array2.add(new customButton1("background11", "background22", true));
        array2.add(new customButton1("background11", "background22", true));
        array2.add(new customButton1("background11", "background22", true));

        adapter = new CustomButtonSettings(this , array);//this is called in customMusicAdapter
        adapter2 = new CustomButtonSettings(this , array2);//
        //then set that adapter to the listView
        listView1.setAdapter(adapter);
        listView2.setAdapter(adapter2);
        //mentioning to update the rows
        adapter.notifyDataSetChanged();
        adapter2.notifyDataSetChanged();

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("calling");
                System.out.println(i);
                System.out.println(l);
                Intent intent = new Intent(Testing1.this , SettingPage.class);
                //navigating to the relevent activity
                startActivity(intent);
            }
        });
    }
}