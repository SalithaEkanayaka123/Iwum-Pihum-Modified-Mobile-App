package com.example.uee_recipe_management.application.bookmark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.bookmark.adapter.BookmarkAdapter;
import com.example.uee_recipe_management.application.bookmark.model.RecipieItem;
import com.example.uee_recipe_management.application.category.model.CategoryItem;

import java.util.ArrayList;

public class Bookmark extends AppCompatActivity {
    RecyclerView longCardRecyclerView;
    BookmarkAdapter bookmarkAdapter;
    ArrayList<RecipieItem> items;
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

    private void filter(String text){
        ArrayList<RecipieItem> filteredList = new ArrayList<>();
        for (RecipieItem item : items){
            if(item.getName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }

        bookmarkAdapter.filterList(filteredList);
    }


    private void setRecyclerSearchCategory(){
        longCardRecyclerView = findViewById(R.id.search_page_recycler_2);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        longCardRecyclerView.setLayoutManager(layoutManager);
        bookmarkAdapter = new BookmarkAdapter(this, items);
        longCardRecyclerView.setAdapter(bookmarkAdapter);
        searchCategoryHeader.setText(header);
    }
}