package com.example.uee_recipe_management.application.bookmark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
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

//        items = this.getIntent().getExtras().getParcelableArrayList("TITELS");
        database = FirebaseDatabase.getInstance("https://uee-recipe-management-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("uploads");

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ItemTesting.this, "You clicked on add item button", Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent(view.getContext(), AddItem.class);
                view.getContext().startActivity(intent);
            }
        });


//        titles = new ArrayList<>();
//        images = new ArrayList<>();
//
//        titles.add("First Item");
//        titles.add("Second Item");
//        titles.add("Third Item");
//        titles.add("Fourth Item");
//        titles.add("Fifth Item");
//        titles.add("Second Item");
//        titles.add("Third Item");
//        titles.add("Fourth Item");
//        titles.add("First Item");
//        titles.add("Second Item");
//        titles.add("Third Item");
//        titles.add("Fourth Item");
//        titles.add("First Item");
//        titles.add("Second Item");
//        titles.add("Third Item");
//        titles.add("Fourth Item");
//
//        images.add(R.drawable.image_1);
//        images.add(R.drawable.image_2);
//        images.add(R.drawable.image_3);
//        images.add(R.drawable.image_4);
//        images.add(R.drawable.image_5);
//        images.add(R.drawable.image_2);
//        images.add(R.drawable.image_3);
//        images.add(R.drawable.image_4);
//        images.add(R.drawable.image_1);
//        images.add(R.drawable.image_2);
//        images.add(R.drawable.image_3);
//        images.add(R.drawable.image_4);
//        images.add(R.drawable.image_1);
//        images.add(R.drawable.image_2);
//        images.add(R.drawable.image_3);
//        images.add(R.drawable.image_4);
//
//
//        itemTestingAdapter = new ItemTestingAdapter(this,titles,images);
//
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
//        dataList.setLayoutManager(gridLayoutManager);
//        dataList.setAdapter((RecyclerView.Adapter) itemTestingAdapter);



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

    private void setRecyclerSearchCategory(){
        dataList = findViewById(R.id.search_page_recycler_new);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        dataList.setLayoutManager(layoutManager);
        itemTestingAdapter = new ItemTestingAdapter(this, fireArrayItems);
        dataList.setAdapter(itemTestingAdapter);
    }
}