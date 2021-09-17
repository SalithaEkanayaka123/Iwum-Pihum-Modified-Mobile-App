package com.example.uee_recipe_management.application.settings.CustomButtonSettings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.settings.model.customButton1;

import java.util.ArrayList;

public class CustomButtonSettings3 extends AppCompatActivity {
    private Context context;
    ArrayList<customButton1> list;
    TextView title1, title2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_button_settings3);
    }
}