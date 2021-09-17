package com.example.uee_recipe_management.application.settings;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings2;
import com.example.uee_recipe_management.application.settings.model.customButton1;

import java.util.ArrayList;

public class SettingPage extends AppCompatActivity {

    ListView listView1;
    CustomButtonSettings2 adapter2;//declaring the Custom adapter
    ArrayList<customButton1> array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_page);

        listView1 = (ListView) findViewById(R.id.listSettings8);

        array = new ArrayList<>();
        array.add(new customButton1("Background", "Handles Background Settings", true));
        array.add(new customButton1("Notification", "Handles Notification Settings", true));
        array.add(new customButton1("Synchronization", "Handles Synchronization Settings", true));
        array.add(new customButton1("Privacy and Policy", "Privacy and Policy", true));
        array.add(new customButton1("About", "About", true));

        adapter2 = new CustomButtonSettings2(this , array);//
        //then set that adapter to the list
        listView1.setAdapter(adapter2);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("calling");
            }
        });
    }
}