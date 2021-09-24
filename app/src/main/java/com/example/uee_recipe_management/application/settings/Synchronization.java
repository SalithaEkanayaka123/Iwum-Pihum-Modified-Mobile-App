package com.example.uee_recipe_management.application.settings;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings2;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings4;
import com.example.uee_recipe_management.application.settings.model.customButton1;

import java.util.ArrayList;

public class Synchronization extends DialogFragment {

    ListView listView1;
    CustomButtonSettings adapter2;//declaring the Custom adapter
    ArrayList<customButton1> array;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1 = inflater.inflate(R.layout.fragment_synchronization, container, false);
        listView1 = (ListView) v1.findViewById(R.id.listSettings11);

        array = new ArrayList<>();
        array.add(new customButton1("Sync", "Automatic background sync", true));
        array.add(new customButton1("Sync on startup", "sync on startup", true));


        adapter2 = new CustomButtonSettings(getContext() , array);//
        //then set that adapter to the list
        listView1.setAdapter(adapter2);

//        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                if (i == 0){
//                    Intent intent  = new Intent(view.getContext(), Background_Settings.class);
//                    view.getContext().startActivity(intent);
//                }else if (i == 1){
//                    Intent intent  = new Intent(view.getContext(), Notification_Settings.class);
//                    view.getContext().startActivity(intent);
//                }else if (i == 2){
//
//                    Synchronization settingsFragment = new Synchronization();
//                    settingsFragment.show(getSupportFragmentManager(),"myFragment");
////                    System.out.println("ww1");
////
////                    System.out.println("ww2");
////                    FragmentManager fragmentManager = getSupportFragmentManager();
////                    System.out.println("ww3");
////                    fragmentManager.beginTransaction().add(R.id.settingsMainPage , settingsFragment).commit();
//                }else if (i == 3){
//                    Intent intent  = new Intent(view.getContext(), PrivacyAndPolicy_Settings.class);
//                    view.getContext().startActivity(intent);
//                }else if (i == 4){
//                    About settingsFragment = new About();
//                    settingsFragment.show(getSupportFragmentManager(),"myFragment1");
//                }
//            }
//        });
        // Inflate the layout for this fragment
        return v1;

    }
}