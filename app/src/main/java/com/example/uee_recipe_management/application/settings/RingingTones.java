package com.example.uee_recipe_management.application.settings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.uee_recipe_management.application.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RingingTones#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RingingTones extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ringing_tones, container, false);
    }
}