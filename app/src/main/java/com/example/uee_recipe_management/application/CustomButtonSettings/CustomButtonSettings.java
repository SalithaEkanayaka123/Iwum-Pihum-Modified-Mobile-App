package com.example.uee_recipe_management.application.CustomButtonSettings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.settings.model.customButton1;

import java.util.ArrayList;

public class CustomButtonSettings extends BaseAdapter {

    private Context context;
    ArrayList<customButton1> list;
    TextView title1, title2;
    ToggleButton toogleButton;

    public CustomButtonSettings(Context context, ArrayList<customButton1> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.activity_custom_button_settings , null);
            //textID = (TextView) view.findViewById(R.id.textID);


        }
        return null;
    }
}