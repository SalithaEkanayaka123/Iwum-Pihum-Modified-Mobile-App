package com.example.uee_recipe_management.application.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.uee_recipe_management.application.CustomButtonSettings.CustomButtonSettings;
import com.example.uee_recipe_management.application.R;

import java.util.ArrayList;

public class Testing1 extends AppCompatActivity {

    ListView listView1, listView2;
    CustomButtonSettings adapter;//declaring the Custom adapter
    //ArrayList<SongList> array;//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing2);
    }
}