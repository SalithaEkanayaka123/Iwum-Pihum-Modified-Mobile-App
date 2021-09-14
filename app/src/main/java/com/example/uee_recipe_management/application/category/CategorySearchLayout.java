package com.example.uee_recipe_management.application.category;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.category.model.CategoryItem;

import java.util.List;

public class CategorySearchLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_search_layout);

        Bundle extras = getIntent().getExtras();
        if(extras!= null){
            List<CategoryItem> items = extras.getParcelable("array");
            for(CategoryItem item : items){
                System.out.println(item.getName());
            }
        }

    }
}