package com.example.uee_recipe_management.application.category;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.uee_recipe_management.application.NavgationController;
import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.category.adapter.CategoriesRecyclerAdapter;
import com.example.uee_recipe_management.application.category.model.AllCategories;
import com.example.uee_recipe_management.application.category.model.CategoryItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ResponsiveVerticalHorizontalLayout extends AppCompatActivity {

    RecyclerView mainCategoryRecycler;
    CategoriesRecyclerAdapter mainRecyclerAdapter;
    EditText searchBar;
    ArrayList<AllCategories> allCategories;
    NavgationController Nav = new NavgationController();
    DatabaseReference database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_responsive_vertical_horizontal_layout);

        /** Firebase Database Connection **/
        database = FirebaseDatabase.getInstance("https://uee-recipe-management-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("uploads");

        //Bottom Nav Configs
        BottomNavigationView bottomNavView  = findViewById(R.id.bottom_nav);
        bottomNavView.setOnNavigationItemSelectedListener( navListener);
        Menu menu = bottomNavView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        /**
         * Following section should be automated.
         * **/

        //Add items to the category item model class.
        List<CategoryItem> categoryItems = new ArrayList<>();
        categoryItems.add(new CategoryItem("Fried Rice", R.drawable.image_1, "This is sample description"));
        categoryItems.add(new CategoryItem("Chicken Kottu", R.drawable.image_2, "This is sample description"));
        categoryItems.add(new CategoryItem("Soup", R.drawable.image_3, "This is sample description"));
        categoryItems.add(new CategoryItem("Coca Cola", R.drawable.image_4, "This is sample description"));
        categoryItems.add(new CategoryItem("Curry", R.drawable.image_5, "This is sample description"));

        //Dummy data to the model class.
        allCategories  = new ArrayList<>();
        allCategories.add(new AllCategories("Cool Drinks", categoryItems));
        allCategories.add(new AllCategories("Main courses",categoryItems));
        allCategories.add(new AllCategories("Short Eats",categoryItems));
        allCategories.add(new AllCategories("Candies",categoryItems));
        allCategories.add(new AllCategories("Steak",categoryItems));
        setMainCategoryRecycler(allCategories);

        /**
         * Search Bar for the Responsive Layout.
         * **/
        searchBar = findViewById(R.id.searchbar_responsive_layout);
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

    public void filter(String searchKey){
        ArrayList<AllCategories> filteredAllCategories = new ArrayList<>();
        for(AllCategories categoryItem : allCategories){
            if(categoryItem.getCategoryName().toLowerCase().contains(searchKey.toLowerCase())){
                filteredAllCategories.add(categoryItem);
            }
        }
        mainRecyclerAdapter.filterList(filteredAllCategories);
    }

    private void setMainCategoryRecycler(List<AllCategories> allCategoriesList){
        mainCategoryRecycler = findViewById(R.id.parent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mainCategoryRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new CategoriesRecyclerAdapter(this, allCategoriesList);
        mainCategoryRecycler.setAdapter(mainRecyclerAdapter);
    }

    private  BottomNavigationView.OnNavigationItemSelectedListener navListener = new
            BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Intent change =  Nav.ChangeMainAcivty(item, ResponsiveVerticalHorizontalLayout.this);
                    startActivity(change);
                    return true;
                }
            };
}