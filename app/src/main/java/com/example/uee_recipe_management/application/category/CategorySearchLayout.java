package com.example.uee_recipe_management.application.category;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.uee_recipe_management.application.NavgationController;
import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.bookmark.firebaseImageUploading.Upload;
import com.example.uee_recipe_management.application.category.adapter.CategoryItemAdapter;
import com.example.uee_recipe_management.application.category.adapter.CategoryItemSearchAdapter;
import com.example.uee_recipe_management.application.category.model.CategoryItem;
import com.example.uee_recipe_management.application.notification.NotificationLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CategorySearchLayout extends AppCompatActivity {
    RecyclerView longCardRecyclerView;
    CategoryItemSearchAdapter categoryItemSearchAdapter;
    ArrayList<CategoryItem> items;
    ArrayList<CategoryItem> fireArrayItems;
    String header;
    TextView searchCategoryHeader;
    EditText searchBar;
    DatabaseReference database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_search_layout);

        /** Parameters From the Responsive Layout **/
        items = this.getIntent().getExtras().getParcelableArrayList("ARRAYLIST");
        header = this.getIntent().getExtras().getString("categoryName"); // header name use to filter the item list.
        System.out.println(header);

        /** Database connection to the Schema **/
        database = FirebaseDatabase.getInstance("https://uee-recipe-management-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("uploads");

        // Testing.
        for(CategoryItem item : items){
            System.out.println(item.getName());
        }

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

        // Calling the layout setting method.
        fireArrayItems = new ArrayList<>();

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Upload upload = dataSnapshot.getValue(Upload.class);
                    // Transfer the objects into CategoryItems.
                    CategoryItem categoryItem = new CategoryItem(upload.getName(), upload.getImageUrl(), upload.getDescription(), upload.getSubName(), upload.getCategory());
                    /** Conditionally Adding the Items to the Array Respect to the Category name **/
                    fireArrayItems.add(categoryItem);
                }
                categoryItemSearchAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
        setRecyclerSearchCategory();

    }

    /** Searching the ArrayList (Firebase) **/
    private void filter(String text){
        ArrayList<CategoryItem> filteredList = new ArrayList<>();
        for (CategoryItem item : fireArrayItems){
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
        categoryItemSearchAdapter = new CategoryItemSearchAdapter(this, fireArrayItems);
        longCardRecyclerView.setAdapter(categoryItemSearchAdapter);
        searchCategoryHeader = findViewById(R.id.search_page_header);
        searchCategoryHeader.setText(header);
    }


}