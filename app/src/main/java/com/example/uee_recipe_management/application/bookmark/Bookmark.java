package com.example.uee_recipe_management.application.bookmark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.uee_recipe_management.application.CustomArrayList.CustomArrayList;
import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.bookmark.adapter.BookmarkAdapter;
import com.example.uee_recipe_management.application.bookmark.model.RecipieItem;
import com.example.uee_recipe_management.application.category.model.CategoryItem;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Bookmark extends AppCompatActivity {

    RecyclerView dataList;
    List<String> titles;
    List<Integer> images;
    BookmarkAdapter bookmarkAdapter;
    ArrayList<RecipieItem> items;
    EditText searchBar;
    ImageButton fvrt_btn;

    FirebaseDatabase database;
    DatabaseReference databaseReference, fvrtref,fvrt_listRef;
    Boolean fvrtChecker = false;
    private CustomArrayList FirebaseAuth;
    //temp
    String currentUserid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);
        dataList = findViewById(R.id.search_page_recycler_2);
        fvrt_btn = findViewById(R.id.fvrt_f2_item);

//        DrawableHelper
//                .withContext(this)
////                .withColor(R.color.white)
//                .withDrawable(R.drawable.ic_baseline_turned_in_24)
//                .tint()
//                .applyTo(settings_icon);




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

            }
        });

//        FirebaseUser user = CustomArrayList.getInstance().getCurrentUser();
//        String currentUserId = user.getUid();

//        fvrtref = database.getReference("favourites");
//        fvrt_listRef = database.getReference("favouriteList").child(currentUserid);

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


        bookmarkAdapter = new BookmarkAdapter(this,titles,images);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter((RecyclerView.Adapter) bookmarkAdapter);

    }

    private void filter(String text){
//        ArrayList<RecipieItem> filteredList = new ArrayList<>();
//        for (A item : items){
//            if(item.getName().toLowerCase().contains(text.toLowerCase())){
//                filteredList.add(item);
//            }
//        }
//
//        bookmarkAdapter.filterList(filteredList);
    }


}