package com.example.uee_recipe_management.application.bookmark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.bookmark.adapter.BookmarkAdapter;
import com.example.uee_recipe_management.application.bookmark.adapter.ItemTestingAdapter;
import com.example.uee_recipe_management.application.bookmark.firebaseImageUploading.Upload;
import com.example.uee_recipe_management.application.bookmark.model.RecipieItem;
import com.example.uee_recipe_management.application.category.adapter.CategoryItemSearchAdapter;
import com.example.uee_recipe_management.application.category.model.CategoryItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ItemTesting extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView dataList;
    List<String> titles;
    List<Integer> images;
    ItemTestingAdapter itemTestingAdapter;
    EditText searchBar;
    DatabaseReference database;
    ArrayList<RecipieItem> items;
    ArrayList<RecipieItem> fireArrayItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_testing);

        fab =findViewById(R.id.add_btn);
        dataList = findViewById(R.id.search_page_recycler_new);

        database = FirebaseDatabase.getInstance("https://uee-recipe-management-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("uploads");

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ItemTesting.this, "You clicked on add item button", Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent(view.getContext(), AddItem.class);
                view.getContext().startActivity(intent);
            }
        });

        searchBar = findViewById(R.id.searchbar_responsive_layout_1);
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


        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Upload upload = dataSnapshot.getValue(Upload.class);
                    // Transfer the objects into CategoryItems.
                    RecipieItem recipieItem = new RecipieItem(upload.getName(), upload.getImageUrl(), upload.getDescription());
                    fireArrayItems.add(recipieItem);
                }
                itemTestingAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        // Calling the layout setting method.
        fireArrayItems = new ArrayList<>();
        setRecyclerSearchCategory();
    }

    /** Searching the ArrayList (Firebase) **/
    private void filter(String text){
        ArrayList<RecipieItem> filteredList = new ArrayList<>();
        for (RecipieItem item : fireArrayItems){
            if(item.getName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }

        itemTestingAdapter.filterList(filteredList);
    }


    private void setRecyclerSearchCategory(){
        dataList = findViewById(R.id.search_page_recycler_new);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        dataList.setLayoutManager(layoutManager);
        itemTestingAdapter = new ItemTestingAdapter(this, fireArrayItems);
        dataList.setAdapter(itemTestingAdapter);
    }
}