package com.example.uee_recipe_management.application.settings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings2;
import com.example.uee_recipe_management.application.settings.model.customButton1;

import java.util.ArrayList;

public class Notification_Settings_Fragment extends Fragment {

    ListView listView1, listView2, listView3;
    CustomButtonSettings adapter, adapter3;
    CustomButtonSettings2 adapter2;//declaring the Custom adapter
    ArrayList<customButton1> array, array2, array3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1 = inflater.inflate(R.layout.fragment_notification__settings_, container, false);

        listView1 = (ListView) v1.findViewById(R.id.listSettings3);
        listView2 = (ListView) v1.findViewById(R.id.listSettings4);
        listView3 = (ListView) v1.findViewById(R.id.listSettings5);

        array = new ArrayList<>();
        array.add(new customButton1(getString(R.string.Notification), getString(R.string.Enablenotificationalertsfornotifications), true));

        array2 = new ArrayList<>();
        array2.add(new customButton1(getString(R.string.RingingTones), getString(R.string.RingingTonesList), true));

        array3 = new ArrayList<>();
        array3.add(new customButton1(getString(R.string.Vibration), getString(R.string.EnableVibration), true));


        adapter = new CustomButtonSettings(getActivity() , array);//this is called in customMusicAdapter
        adapter2 = new CustomButtonSettings2(getActivity() , array2);//
        adapter3 = new CustomButtonSettings(getActivity() , array3);
        //then set that adapter to the listView
        listView1.setAdapter(adapter);
        listView2.setAdapter(adapter2);
        listView3.setAdapter(adapter3);
        listView1.setItemsCanFocus(false);


        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    RingingTones settingsFragment = new RingingTones();
                    settingsFragment.show(getChildFragmentManager(),"myFragment");
                }
            }
        });

        return v1;
    }
}