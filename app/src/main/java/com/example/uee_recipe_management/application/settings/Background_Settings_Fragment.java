package com.example.uee_recipe_management.application.settings;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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

public class Background_Settings_Fragment extends Fragment {


    ListView listView1, listView2;
    CustomButtonSettings adapter;

    CustomButtonSettings2 adapter2;//declaring the Custom adapter
    ArrayList<customButton1> array, array2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1 = inflater.inflate(R.layout.fragment_background__settings_, container, false);
        listView1 = (ListView) v1.findViewById(R.id.listSettings6);
        listView2 = (ListView) v1.findViewById(R.id.listSettings7);

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            getActivity().setTheme(R.style.DarkTheme);

        }else{
            getActivity().setTheme(R.style.AppTheme);
        }

        array = new ArrayList<>();
        array.add(new customButton1(getString(R.string.DarkMode), getString(R.string.EnableDarkMode), true));

        array2 = new ArrayList<>();
        array2.add(new customButton1(getString(R.string.DisplayLanguage), getString(R.string.Choosealanguage), true));
        array2.add(new customButton1(getString(R.string.SwitchLayout), getString(R.string.Changethelayoutsofinterface), true));
        array2.add(new customButton1(getString(R.string.SortBy), getString(R.string.SortBy), true));


        adapter = new CustomButtonSettings(getActivity() , array);//this is called in customMusicAdapter
        adapter2 = new CustomButtonSettings2(getActivity() , array2);//
        //then set that adapter to the listView
        listView1.setAdapter(adapter);
        listView2.setAdapter(adapter2);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    DisplayLanguage settingsFragment = new DisplayLanguage();
                    settingsFragment.show(getChildFragmentManager(),"myFragment");
//                    FragmentTransaction fr = getFragmentManager().beginTransaction();
//                    fr.replace(R.id.container1,new DisplayLanguage());
//                    fr.commit();
                }else if (i == 1){
                    LayoutFragment settingsFragment = new LayoutFragment();
                    settingsFragment.show(getChildFragmentManager(),"myFragment");
//                    FragmentTransaction fr = getFragmentManager().beginTransaction();
//                    fr.replace(R.id.container1,new LayoutFragment());
//                    fr.commit();
                }else if (i == 2){
                    SortBy settingsFragment = new SortBy();
                    settingsFragment.show(getChildFragmentManager(),"myFragment");
//                    FragmentTransaction fr = getFragmentManager().beginTransaction();
//                    fr.replace(R.id.container1,new SortBy());
//                    fr.commit();

                }
            }
        });

        return v1;
    }

}