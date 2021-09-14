package com.example.uee_recipe_management.application.category;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.category.adapter.CategoriesRecyclerAdapter;
import com.example.uee_recipe_management.application.category.model.AllCategories;
import com.example.uee_recipe_management.application.category.model.CategoryItem;

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

        /**
         * Following section should be automated.
         * **/

        //Add items to the category item model class.
        List<CategoryItem> categoryItems = new ArrayList<>();
        categoryItems.add(new CategoryItem("Name", R.drawable.image1, "This is sample description"));
        categoryItems.add(new CategoryItem("Name", R.drawable.image2, "This is sample description"));
        categoryItems.add(new CategoryItem("Name", R.drawable.image3, "This is sample description"));
        categoryItems.add(new CategoryItem("Name", R.drawable.image4, "This is sample description"));
        categoryItems.add(new CategoryItem("Name", R.drawable.image5, "This is sample description"));

        //Dummy data to the model class.
        List<AllCategories> allCategories  = new ArrayList<>();
        allCategories.add(new AllCategories("Cool Drinks", categoryItems));
        allCategories.add(new AllCategories("Main courses",categoryItems));
        allCategories.add(new AllCategories("Short Eats",categoryItems));
        allCategories.add(new AllCategories("Candies",categoryItems));
        allCategories.add(new AllCategories("Steak",categoryItems));
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