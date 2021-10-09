package com.example.uee_recipe_management.application.settings;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings4;
import com.example.uee_recipe_management.application.settings.model.customButton1;

import java.util.ArrayList;

public class DisplayLanguage extends DialogFragment {

    ListView listView1;
    CustomButtonSettings4 adapter2;//declaring the Custom adapter
    ArrayList<customButton1> array;
    CardView cardView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1 = inflater.inflate(R.layout.fragment_display_language, container, false);
        listView1 = (ListView) v1.findViewById(R.id.listSettings12);
        cardView = (CardView) v1.findViewById(R.id.custombuttonsettings4);

        array = new ArrayList<>();
        array.add(new customButton1(getString(R.string.English), "Automatic background sync", true));
        array.add(new customButton1(getString(R.string.Sinhala), "sync on startup", true));


        adapter2 = new CustomButtonSettings4(getContext() , array);//
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