package com.example.uee_recipe_management.application.settings;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings4;
import com.example.uee_recipe_management.application.settings.CustomButtonSettings.CustomButtonSettings5;
import com.example.uee_recipe_management.application.settings.model.RingingTone;
import com.example.uee_recipe_management.application.settings.model.customButton1;

import java.io.IOException;
import java.util.ArrayList;

public class RingingTones extends DialogFragment {

    ListView listView1;
    CustomButtonSettings5 adapter2;//declaring the Custom adapter
    ArrayList<RingingTone> array;
    private MediaPlayer mediaPlayer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1 = inflater.inflate(R.layout.fragment_ringing_tones, container, false);
        listView1 = (ListView) v1.findViewById(R.id.listSettings13);
        mediaPlayer = new MediaPlayer();

        array = new ArrayList<>();
        array.add(new RingingTone("RingingTone1", R.raw.music1));
        array.add(new RingingTone("RingingTone2", R.raw.music2));
        array.add(new RingingTone("RingingTone3", R.raw.music3));
        array.add(new RingingTone("RingingTone4", R.raw.music4));
        array.add(new RingingTone("RingingTone5", R.raw.music5));
        array.add(new RingingTone("Stop", R.raw.music5));


        adapter2 = new CustomButtonSettings5(getContext() , array);
        //then set that adapter to the list
        listView1.setAdapter(adapter2);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.setSelected(true);
                if (i == 0){
                    System.out.println("1");
                    mediaPlayer.stop();
                    mediaPlayer=MediaPlayer.create(getActivity().getApplicationContext(),R.raw.music1);
                    mediaPlayer.start();


                }else if (i == 1){
                    //mediaPlayer=MediaPlayer.create(getActivity().getApplicationContext(),R.raw.music1);
                    mediaPlayer.stop();
                    mediaPlayer=MediaPlayer.create(getActivity().getApplicationContext(),R.raw.music2);
                    mediaPlayer.start();
                }else if (i == 2){
                    System.out.println("3");
                    mediaPlayer.stop();
                    mediaPlayer=MediaPlayer.create(getActivity().getApplicationContext(),R.raw.music3);
                    mediaPlayer.start();
                }else if (i == 3){
                    System.out.println("4");
                    mediaPlayer.stop();
                    mediaPlayer=MediaPlayer.create(getActivity().getApplicationContext(),R.raw.music4);
                    mediaPlayer.start();
                }else if (i == 4){
                    System.out.println("5");
                    mediaPlayer.stop();
                    mediaPlayer=MediaPlayer.create(getActivity().getApplicationContext(),R.raw.music5);
                    mediaPlayer.start();
                }
                else if (i == 5){
                    System.out.println("6");
                    mediaPlayer.stop();
                }
            }
        });
        return v1;
    }
}