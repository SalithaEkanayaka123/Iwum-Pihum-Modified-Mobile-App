package com.example.uee_recipe_management.application.category;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
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
    EditText searchBar;

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

        /**
         * Search Bar Listener.
         * **/
        searchBar = findViewById(R.id.search_layout_search);
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });

    }

    private void filter(String text){
        ArrayList<CategoryItem> filteredList = new ArrayList<>();
        for (CategoryItem item : items){
            if(item.getName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }

        categoryItemSearchAdapter.filterList(filteredList);
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