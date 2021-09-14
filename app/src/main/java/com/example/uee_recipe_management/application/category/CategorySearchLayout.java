package com.example.uee_recipe_management.application.category;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.category.adapter.CategoryItemSearchAdapter;
import com.example.uee_recipe_management.application.category.model.CategoryItem;

import java.util.ArrayList;
import java.util.List;

public class CategorySearchLayout extends AppCompatActivity {
    RecyclerView longCardRecyclerView;
    CategoryItemSearchAdapter categoryItemSearchAdapter;
    ArrayList<CategoryItem> items;
    String header;
    TextView searchCategoryHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_search_layout);
        items = this.getIntent().getExtras().getParcelableArrayList("ARRAYLIST");
        header = this.getIntent().getExtras().getString("categoryName");
        System.out.println(header);

        // Testing.
        for(CategoryItem item : items){
            System.out.println(item.getName());
        }
        // Calling the layout setting method.
        setRecyclerSearchCategory();
    }
    private void setRecyclerSearchCategory(){
        longCardRecyclerView = findViewById(R.id.search_page_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        longCardRecyclerView.setLayoutManager(layoutManager);
        categoryItemSearchAdapter = new CategoryItemSearchAdapter(this, items);
        longCardRecyclerView.setAdapter(categoryItemSearchAdapter);
        searchCategoryHeader = findViewById(R.id.search_page_header);
        searchCategoryHeader.setText(header);
    }
}