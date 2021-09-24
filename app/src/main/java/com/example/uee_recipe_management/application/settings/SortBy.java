package com.example.uee_recipe_management.application.settings;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings4;
import com.example.uee_recipe_management.application.settings.model.customButton1;

import java.util.ArrayList;

public class SortBy extends DialogFragment {

    ListView listView1;
    CustomButtonSettings4 adapter2;//declaring the Custom adapter
    ArrayList<customButton1> array;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1 = inflater.inflate(R.layout.fragment_sort_by, container, false);
        listView1 = (ListView) v1.findViewById(R.id.listSettings14);

        array = new ArrayList<>();
        array.add(new customButton1("Title", "Automatic background sync", true));
        array.add(new customButton1("Date Ascending", "sync on startup", true));
        array.add(new customButton1("Date Descending", "sync on startup", true));
        array.add(new customButton1("Download Ascending", "sync on startup", true));


        adapter2 = new CustomButtonSettings4(getContext() , array);//
        //then set that adapter to the list
        listView1.setAdapter(adapter2);
        return v1;
    }
}