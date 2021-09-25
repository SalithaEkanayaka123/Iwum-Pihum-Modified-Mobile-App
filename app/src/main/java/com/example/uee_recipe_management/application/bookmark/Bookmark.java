package com.example.uee_recipe_management.application.bookmark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.category.adapter.CategoryItemSearchAdapter;
import com.example.uee_recipe_management.application.category.model.CategoryItem;

import java.util.ArrayList;

public class Bookmark extends AppCompatActivity {
    RecyclerView longCardRecyclerView;
    CategoryItemSearchAdapter categoryItemSearchAdapter;
    ArrayList<CategoryItem> items;
    String header;
    TextView searchCategoryHeader;
    EditText searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        /**
         * Search Bar Listener.
         * **/
        searchBar = findViewById(R.id.search_layout_search_2);
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //filter(editable.toString());
            }
        });





    }
}