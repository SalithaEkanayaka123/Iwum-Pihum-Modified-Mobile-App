package com.example.uee_recipe_management.application.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings2;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings3;
import com.example.uee_recipe_management.application.settings.model.customButton1;

import java.util.ArrayList;

public class PrivacyAndPolicy_Settings extends AppCompatActivity {
    ListView listView1;
    CustomButtonSettings3 adapter2;//declaring the Custom adapter
    ArrayList<customButton1> array;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_and_policy__settings);

        listView1 = (ListView) findViewById(R.id.listSettings9);

        array = new ArrayList<>();
        array.add(new customButton1("Information Collection and Use", "Handles Background Settings", true));
        array.add(new customButton1("Log Data", "Handles Background Settings", true));
        array.add(new customButton1("Cookies", "Handles Background Settings", true));
        array.add(new customButton1("Service Providers", "Handles Background Settings", true));
        array.add(new customButton1("Security", "Handles Background Settings", true));

        adapter2 = new CustomButtonSettings3(this , array);//
        //then set that adapter to the list
        listView1.setAdapter(adapter2);



//        listView1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.out.println("calling 1222");
//            }
//        });
    }
}