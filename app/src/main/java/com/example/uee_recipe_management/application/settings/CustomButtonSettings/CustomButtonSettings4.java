package com.example.uee_recipe_management.application.settings.CustomButtonSettings;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.settings.model.customButton1;

import java.util.ArrayList;

public class CustomButtonSettings4 extends BaseAdapter {

    private Context context;
    ArrayList<customButton1> list;
    TextView title1;
    CardView cardView;

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
            view = layoutInflater.inflate(R.layout.activity_custom_button_settings4 , null);

            title1 = (TextView) view.findViewById(R.id.settingstitle7);
            cardView = (CardView) view.findViewById(R.id.custombuttonsettings4);

            final customButton1 customButton1 = list.get(i);

            String name1 = customButton1.getTitle1();
            title1.setText(name1);
//            view.setOnTouchListener(new View.OnTouchListener() {
//                @Override
//                public boolean onTouch(View view, MotionEvent motionEvent) {
//                    System.out.println("fffff");
//                    cardView.setCardBackgroundColor(Color.parseColor("#488747"));
//                    return true;
//                }
//            });
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("fffff");
                    //cardView.setBackgroundColor(ContextCompat.getColor(, R.color.teal_200));
                    //cardView.setCardBackgroundColor(Color.parseColor("#488747"));
                    //cardView.setCardBackgroundColor(ContextCompat.getColor(Color.parseColor("#FFFFFF")));
                }
            });
        }
        return view;
    }
}