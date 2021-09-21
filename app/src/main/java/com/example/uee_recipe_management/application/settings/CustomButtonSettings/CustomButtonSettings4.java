package com.example.uee_recipe_management.application.settings.CustomButtonSettings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.settings.model.customButton1;

import java.util.ArrayList;

public class CustomButtonSettings4 extends BaseAdapter {

    private Context context;
    ArrayList<customButton1> list;
    TextView title1;

    public CustomButtonSettings4(Context context, ArrayList<customButton1> list) {
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
            view = layoutInflater.inflate(R.layout.activity_custom_button_settings2 , null);

            title1 = (TextView) view.findViewById(R.id.settingstitle7);

            final customButton1 customButton1 = list.get(i);

            String name1 = customButton1.getTitle1();
            title1.setText(name1);
        }
        return view;
    }
}