package com.example.uee_recipe_management.application.settings;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings2;
import com.example.uee_recipe_management.application.settings.model.customButton1;

import java.util.ArrayList;

public class Notification_Settings extends AppCompatActivity {

    ListView listView1, listView2, listView3;
    CustomButtonSettings adapter, adapter3;
    CustomButtonSettings2 adapter2;//declaring the Custom adapter
    ArrayList<customButton1> array, array2, array3;//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification__settings);

        listView1 = (ListView) findViewById(R.id.listSettings3);
        listView2 = (ListView) findViewById(R.id.listSettings4);
        listView3 = (ListView) findViewById(R.id.listSettings5);

        array = new ArrayList<>();
        array.add(new customButton1("Notification", "Enable notification alerts for notifications", true));

        array2 = new ArrayList<>();
        array2.add(new customButton1("Ringing Tones", "Ringing Tones List", true));

        array3 = new ArrayList<>();
        array3.add(new customButton1("Vibration", "Enable Vibration alerts for notifications", true));


        adapter = new CustomButtonSettings(this , array);//this is called in customMusicAdapter
        adapter2 = new CustomButtonSettings2(this , array2);//
        adapter3 = new CustomButtonSettings(this , array3);
        //then set that adapter to the listView
        listView1.setAdapter(adapter);
        listView2.setAdapter(adapter2);
        listView3.setAdapter(adapter3);
        listView1.setItemsCanFocus(false);
    }
}