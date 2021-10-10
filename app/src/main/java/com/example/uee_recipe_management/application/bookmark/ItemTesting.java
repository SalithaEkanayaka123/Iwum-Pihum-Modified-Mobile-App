package com.example.uee_recipe_management.application.bookmark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.bookmark.adapter.BookmarkAdapter;
import com.example.uee_recipe_management.application.bookmark.adapter.ItemTestingAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ItemTesting extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView dataList;
    List<String> titles;
    List<Integer> images;
    ItemTestingAdapter itemTestingAdapter;
    EditText searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_testing);

        fab =findViewById(R.id.add_btn);
        dataList = findViewById(R.id.search_page_recycler_new);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ItemTesting.this, "You clicked on add item button", Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent(view.getContext(), AddItem.class);
                view.getContext().startActivity(intent);
            }
        });


        titles = new ArrayList<>();
        images = new ArrayList<>();

        titles.add("First Item");
        titles.add("Second Item");
        titles.add("Third Item");
        titles.add("Fourth Item");
        titles.add("Fifth Item");
        titles.add("Second Item");
        titles.add("Third Item");
        titles.add("Fourth Item");
        titles.add("First Item");
        titles.add("Second Item");
        titles.add("Third Item");
        titles.add("Fourth Item");
        titles.add("First Item");
        titles.add("Second Item");
        titles.add("Third Item");
        titles.add("Fourth Item");

        images.add(R.drawable.image_1);
        images.add(R.drawable.image_2);
        images.add(R.drawable.image_3);
        images.add(R.drawable.image_4);
        images.add(R.drawable.image_5);
        images.add(R.drawable.image_2);
        images.add(R.drawable.image_3);
        images.add(R.drawable.image_4);
        images.add(R.drawable.image_1);
        images.add(R.drawable.image_2);
        images.add(R.drawable.image_3);
        images.add(R.drawable.image_4);
        images.add(R.drawable.image_1);
        images.add(R.drawable.image_2);
        images.add(R.drawable.image_3);
        images.add(R.drawable.image_4);


        itemTestingAdapter = new ItemTestingAdapter(this,titles,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter((RecyclerView.Adapter) itemTestingAdapter);





    }
}