package com.example.uee_recipe_management.application.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.example.uee_recipe_management.application.NavgationController;
import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.bookmark.firebaseImageUploading.Upload;
import com.example.uee_recipe_management.application.bookmark.model.RecipieItem;
import com.example.uee_recipe_management.application.category.adapter.CategoryItemSearchAdapter;
import com.example.uee_recipe_management.application.category.model.CategoryItem;
import com.example.uee_recipe_management.application.home.Adapter.HomeAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    RecyclerView longCardRecyclerView;
    HomeAdapter homeAdapter;
    DatabaseReference mDatabaseRef;
    ArrayList<CategoryItem> items;
    ArrayList<CategoryItem> fireArrayItems;



    NavgationController Nav = new NavgationController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav);
        bottomNavView.setOnNavigationItemSelectedListener(navListener);
        Menu menu = bottomNavView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
        mDatabaseRef = FirebaseDatabase.getInstance("https://uee-recipe-management-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("uploads");


        //Add items to the category item model class.
//        List<CategoryItem> categoryItems = new ArrayList<>();
//        categoryItems.add(new CategoryItem("Fried Rice", R.drawable.image_1, "This is sample description"));
//        categoryItems.add(new CategoryItem("Chicken Kottu", R.drawable.image_2, "This is sample description"));
//        categoryItems.add(new CategoryItem("Soup", R.drawable.image_3, "This is sample description"));
//        categoryItems.add(new CategoryItem("Coca Cola", R.drawable.image_4, "This is sample description"));
//        setRecyclerHome(categoryItems);


        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Upload upload = dataSnapshot.getValue(Upload.class);
                    // Transfer the objects into CategoryItems.
                    CategoryItem categoryItem = new CategoryItem(upload.getName(), upload.getImageUrl(), upload.getDescription(), upload.getSubName(), upload.getCategory());
                    fireArrayItems.add(categoryItem);
                }
                homeAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        // Calling the layout setting method.
        fireArrayItems = new ArrayList<>();
        setRecyclerHome(fireArrayItems);

    }

    private  BottomNavigationView.OnNavigationItemSelectedListener navListener = new
            BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                   Intent change =  Nav.ChangeMainAcivty(item, Home.this);
                    startActivity(change);
                    return true;
                }
    };

    private void setRecyclerHome(List<CategoryItem> hItems){
        longCardRecyclerView = findViewById(R.id.home_page_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        longCardRecyclerView.setLayoutManager(layoutManager);
        homeAdapter = new HomeAdapter(this, hItems, mDatabaseRef);
        longCardRecyclerView.setAdapter(homeAdapter);
    }
}