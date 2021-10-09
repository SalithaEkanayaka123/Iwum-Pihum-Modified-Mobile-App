package com.example.uee_recipe_management.application.settings;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings4;
import com.example.uee_recipe_management.application.settings.model.customButton1;

import java.util.ArrayList;
import java.util.Locale;

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
                System.out.println(i);
                if (i == 0){
                    Locale locale = new Locale("en");
                    Locale.setDefault(locale);
                    Resources resources = getResources();
                    Configuration config = resources.getConfiguration();
                    config.setLocale(locale);
                    resources.updateConfiguration(config, resources.getDisplayMetrics());
//                    Locale locale = new Locale("si", "LK");
//                    Locale.setDefault(locale);
//                    Configuration config = new Configuration();
//                    config.locale = locale;
//                    getActivity().getBaseContext().getResources().updateConfiguration(config, getActivity().getBaseContext().getResources().getDisplayMetrics());

                    Toast.makeText(getContext(), "change to English", Toast.LENGTH_SHORT).show();
                }else if (i == 1){
                    String languageToLoad  = "fr";
                    Locale locale = new Locale("si", "lk");
                    Locale.setDefault(locale);
                    Configuration config = new Configuration();
                    config.locale = locale;
                    getResources().updateConfiguration(config, getResources().getDisplayMetrics());
//                    Locale locale = new Locale("si", "lk");
//                    Locale.setDefault(locale);
//                    Resources resources = getResources();
//                    Configuration config = resources.getConfiguration();
//                    config.setLocale(locale);
//                    resources.updateConfiguration(config, resources.getDisplayMetrics());
                    Toast.makeText(getContext(), "change to Sinhala", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v1;
    }
}