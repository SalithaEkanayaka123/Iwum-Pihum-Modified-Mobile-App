package com.example.uee_recipe_management.application.settings;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;

import com.example.uee_recipe_management.application.R;

public class LayoutFragment extends DialogFragment {

    View v1;
    GridLayout gridLayout;
    Button b1, b2, b3, b4, b5, b6;
    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v1 = inflater.inflate(R.layout.fragment_layout, container, false);
        b1 = (Button) v1.findViewById(R.id.layout_1_1);
        b2 = (Button) v1.findViewById(R.id.layout_2_1);
        b3 = (Button) v1.findViewById(R.id.layout_3_1);
        b4 = (Button) v1.findViewById(R.id.layout_4_1);
        b5 = (Button) v1.findViewById(R.id.layout_5_1);
        b6 = (Button) v1.findViewById(R.id.layout_6_1);
        gridLayout = (GridLayout) v1.findViewById(R.id.mainGridLayout);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1.setBackgroundColor(Color.parseColor("#32021F"));
                b2.setBackground(getContext().getResources().getDrawable(R.drawable.shape2));
                b3.setBackground(getContext().getResources().getDrawable(R.drawable.shape3));
                b4.setBackground(getContext().getResources().getDrawable(R.drawable.shape4));
                b5.setBackground(getContext().getResources().getDrawable(R.drawable.shape5));
                b6.setBackground(getContext().getResources().getDrawable(R.drawable.shape6));
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b2.setBackgroundColor(Color.parseColor("#32021F"));
                b1.setBackground(getContext().getResources().getDrawable(R.drawable.shape1));
                b3.setBackground(getContext().getResources().getDrawable(R.drawable.shape3));
                b4.setBackground(getContext().getResources().getDrawable(R.drawable.shape4));
                b5.setBackground(getContext().getResources().getDrawable(R.drawable.shape5));
                b6.setBackground(getContext().getResources().getDrawable(R.drawable.shape6));
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b3.setBackgroundColor(Color.parseColor("#32021F"));
                b1.setBackground(getContext().getResources().getDrawable(R.drawable.shape1));
                b2.setBackground(getContext().getResources().getDrawable(R.drawable.shape2));
                b4.setBackground(getContext().getResources().getDrawable(R.drawable.shape4));
                b5.setBackground(getContext().getResources().getDrawable(R.drawable.shape5));
                b6.setBackground(getContext().getResources().getDrawable(R.drawable.shape6));
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b3.setBackgroundColor(Color.parseColor("#32021F"));
                b1.setBackground(getContext().getResources().getDrawable(R.drawable.shape1));
                b2.setBackground(getContext().getResources().getDrawable(R.drawable.shape2));
                b4.setBackground(getContext().getResources().getDrawable(R.drawable.shape4));
                b5.setBackground(getContext().getResources().getDrawable(R.drawable.shape5));
                b6.setBackground(getContext().getResources().getDrawable(R.drawable.shape6));
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b4.setBackgroundColor(Color.parseColor("#32021F"));
                b1.setBackground(getContext().getResources().getDrawable(R.drawable.shape1));
                b3.setBackground(getContext().getResources().getDrawable(R.drawable.shape3));
                b2.setBackground(getContext().getResources().getDrawable(R.drawable.shape2));
                b5.setBackground(getContext().getResources().getDrawable(R.drawable.shape5));
                b6.setBackground(getContext().getResources().getDrawable(R.drawable.shape6));
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b5.setBackgroundColor(Color.parseColor("#32021F"));
                b1.setBackground(getContext().getResources().getDrawable(R.drawable.shape1));
                b3.setBackground(getContext().getResources().getDrawable(R.drawable.shape3));
                b4.setBackground(getContext().getResources().getDrawable(R.drawable.shape4));
                b2.setBackground(getContext().getResources().getDrawable(R.drawable.shape2));
                b6.setBackground(getContext().getResources().getDrawable(R.drawable.shape6));
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b6.setBackgroundColor(Color.parseColor("#32021F"));
                b1.setBackground(getContext().getResources().getDrawable(R.drawable.shape1));
                b3.setBackground(getContext().getResources().getDrawable(R.drawable.shape3));
                b4.setBackground(getContext().getResources().getDrawable(R.drawable.shape4));
                b5.setBackground(getContext().getResources().getDrawable(R.drawable.shape5));
                b2.setBackground(getContext().getResources().getDrawable(R.drawable.shape2));
            }
        });

        return v1;
    }
}