package com.example.uee_recipe_management.application.userControlMenu.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.category.model.CategoryItem;
import com.example.uee_recipe_management.application.home.Adapter.HomeAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends Fragment {

    RecyclerView longCardRecyclerView;
    HistoryAdapter historyAdapter;
    DatabaseReference mDatabaseRef;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_history, container, false);

        List<CategoryItem> categoryItems = new ArrayList<>();
        categoryItems.add(new CategoryItem("Fried Rice", R.drawable.image_1, "This is sample description"));
        categoryItems.add(new CategoryItem("Chicken Kottu", R.drawable.image_2, "This is sample description"));
        categoryItems.add(new CategoryItem("Soup", R.drawable.image_3, "This is sample description"));
        categoryItems.add(new CategoryItem("Coca Cola", R.drawable.image_4, "This is sample description"));
        setRecyclerHistory(categoryItems , view);

        mDatabaseRef = FirebaseDatabase.getInstance("https://uee-recipe-management-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("history");

        return view;
    }

    private void setRecyclerHistory(List<CategoryItem> hItems,View view){
        longCardRecyclerView = view.findViewById(R.id.history_page_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        longCardRecyclerView.setLayoutManager(layoutManager);
        historyAdapter = new HistoryAdapter(getContext(), hItems, mDatabaseRef);
        longCardRecyclerView.setAdapter(historyAdapter);
    }
}