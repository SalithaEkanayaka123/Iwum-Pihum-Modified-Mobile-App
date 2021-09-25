package com.example.uee_recipe_management.application.settings;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings4;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings5;
import com.example.uee_recipe_management.application.settings.model.RingingTone;
import com.example.uee_recipe_management.application.settings.model.customButton1;

import java.util.ArrayList;

public class RingingTones extends DialogFragment {

    ListView listView1;
    CustomButtonSettings5 adapter2;//declaring the Custom adapter
    ArrayList<RingingTone> array;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1 = inflater.inflate(R.layout.fragment_ringing_tones, container, false);
        listView1 = (ListView) v1.findViewById(R.id.listSettings13);

        array = new ArrayList<>();
        array.add(new RingingTone("RingingTone1", "Automatic background sync"));
        array.add(new RingingTone("RingingTone2", "Automatic background sync"));
        array.add(new RingingTone("RingingTone3", "Automatic background sync"));
        array.add(new RingingTone("RingingTone4", "Automatic background sync"));
        array.add(new RingingTone("RingingTone5", "Automatic background sync"));


        adapter2 = new CustomButtonSettings5(getContext() , array);//
        //then set that adapter to the list
        listView1.setAdapter(adapter2);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.setSelected(true);
            }
        });
        return v1;
    }
}