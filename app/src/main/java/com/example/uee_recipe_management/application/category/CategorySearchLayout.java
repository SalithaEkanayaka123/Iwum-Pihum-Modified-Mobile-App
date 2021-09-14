package com.example.uee_recipe_management.application.category;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.category.model.CategoryItem;

import java.util.ArrayList;
import java.util.List;

public class CategorySearchLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_search_layout);

        ArrayList<CategoryItem> items = this.getIntent().getExtras().getParcelableArrayList("ARRAYLIST");

        for(CategoryItem item : items){
            System.out.println(item.getName());
        }

    }
}