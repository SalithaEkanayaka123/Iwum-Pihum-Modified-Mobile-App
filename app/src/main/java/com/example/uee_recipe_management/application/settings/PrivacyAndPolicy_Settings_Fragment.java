package com.example.uee_recipe_management.application.settings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings3;
import com.example.uee_recipe_management.application.settings.model.customButton1;

import java.util.ArrayList;


public class PrivacyAndPolicy_Settings_Fragment extends Fragment {

    ListView listView1;
    CustomButtonSettings3 adapter2;//declaring the Custom adapter
    ArrayList<customButton1> array;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1 = inflater.inflate(R.layout.fragment_privacy_and_policy__settings_, container, false);
        listView1 = (ListView) v1.findViewById(R.id.listSettings9);

        array = new ArrayList<>();
        array.add(new customButton1("Information Collection and Use", "Handles Background Settings", true));
        array.add(new customButton1("Log Data", "Handles Background Settings", true));
        array.add(new customButton1("Cookies", "Handles Background Settings", true));
        array.add(new customButton1("Service Providers", "Handles Background Settings", true));
        array.add(new customButton1("Security", "Handles Background Settings", true));

        adapter2 = new CustomButtonSettings3(getActivity() , array);//
        //then set that adapter to the list
        listView1.setAdapter(adapter2);
        return v1;
    }
}