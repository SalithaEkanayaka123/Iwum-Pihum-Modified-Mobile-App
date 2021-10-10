package com.example.uee_recipe_management.application.userControlMenu.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.bookmark.AddItem;
import com.example.uee_recipe_management.application.bookmark.Bookmark;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BookmarkFragment extends Fragment {

    FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bookmark, container, false);

        fab = view.findViewById(R.id.floatingActionButtonBookmark);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "You clicked on add item button", Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent(view.getContext(), Bookmark.class);
                view.getContext().startActivity(intent);
            }
        });
        return view;
    }
}