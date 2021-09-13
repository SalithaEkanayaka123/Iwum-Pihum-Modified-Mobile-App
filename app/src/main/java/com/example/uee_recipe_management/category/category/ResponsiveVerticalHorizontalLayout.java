package com.example.uee_recipe_management.category.category;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.uee_recipe_management.category.R;
import com.example.uee_recipe_management.category.category.adapter.CategoriesRecyclerAdapter;
import com.example.uee_recipe_management.category.category.model.AllCategories;

import java.util.ArrayList;
import java.util.List;

public class ResponsiveVerticalHorizontalLayout extends AppCompatActivity {

    RecyclerView mainCategoryRecycler;
    CategoriesRecyclerAdapter mainRecyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_responsive_vertical_horizontal_layout);

        //Dummy data to the model class.
        List<AllCategories> allCategories  = new ArrayList<>();
        allCategories.add(new AllCategories("Cool Drinks"));
        allCategories.add(new AllCategories("Main courses"));
        allCategories.add(new AllCategories("Short Eats"));
        allCategories.add(new AllCategories("Candies"));
        allCategories.add(new AllCategories("Steak"));

        setMainCategoryRecycler(allCategories);
    }

    private void setMainCategoryRecycler(List<AllCategories> allCategoriesList){
        mainCategoryRecycler = findViewById(R.id.parent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mainCategoryRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new CategoriesRecyclerAdapter(this, allCategoriesList);
        mainCategoryRecycler.setAdapter(mainRecyclerAdapter);
    }
}