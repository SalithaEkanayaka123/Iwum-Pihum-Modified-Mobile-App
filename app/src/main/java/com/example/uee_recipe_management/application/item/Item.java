package com.example.uee_recipe_management.application.item;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.uee_recipe_management.application.R;
import com.smarteist.autoimageslider.SliderView;

import java.util.Objects;

public class Item extends AppCompatActivity {

    SliderView sliderView;
    int[] images = {R.drawable.img_1, R.drawable.img_2, R.drawable.img_3,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item2);

        // Toolbar should be androidx version.
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }
}