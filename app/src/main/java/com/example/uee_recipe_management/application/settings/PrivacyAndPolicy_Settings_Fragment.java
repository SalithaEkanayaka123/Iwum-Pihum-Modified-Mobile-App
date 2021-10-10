package com.example.uee_recipe_management.application.settings;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings3;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings5;
import com.example.uee_recipe_management.application.settings.model.Audio;
import com.example.uee_recipe_management.application.settings.model.Privacy;
import com.example.uee_recipe_management.application.settings.model.customButton1;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class PrivacyAndPolicy_Settings_Fragment extends Fragment {

    ListView listView1;
    CustomButtonSettings3 adapter2;//declaring the Custom adapter
    ArrayList<customButton1> array;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    customButton1 customButton1, customButton;
    Privacy privacy;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1 = inflater.inflate(R.layout.fragment_privacy_and_policy__settings_, container, false);
        listView1 = (ListView) v1.findViewById(R.id.listSettings9);
        firebaseDatabase = FirebaseDatabase.getInstance("https://uee-recipe-management-default-rtdb.asia-southeast1.firebasedatabase.app/");
        databaseReference = firebaseDatabase.getReference("Privacy");
        array = new ArrayList<>();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds:snapshot.getChildren()) {
                    System.out.println("fff " + ds);


                    privacy = ds.getValue(Privacy.class);
                    customButton1 = new customButton1(privacy.getTitle1(),privacy.getTitle2(), false);
//                    System.out.println("dd " + audio1.getTitle());
                    array.add(customButton1);

                }
                adapter2 = new CustomButtonSettings3(getContext() , array);
                //then set that adapter to the list
                listView1.setAdapter(adapter2);
//                String value = snapshot.getValue(Audio.class).toString();
//                //array.add(new Audio(value, value));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        array = new ArrayList<>();
//        array.add(new customButton1("Information Collection and Use", "Handles Background Settings", true));
//        array.add(new customButton1("Log Data", "Handles Background Settings", true));
//        array.add(new customButton1("Cookies", "Handles Cookies", true));
//        array.add(new customButton1("Service Providers", "Handles Services", true));
//        array.add(new customButton1("Security", "Handles Security", true));
//
//        adapter2 = new CustomButtonSettings3(getActivity() , array);//
//        //then set that adapter to the list
//        listView1.setAdapter(adapter2);
        return v1;
    }
}