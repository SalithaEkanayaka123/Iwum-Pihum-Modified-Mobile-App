package com.example.uee_recipe_management.application.settings.CustomButtonSettings;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.settings.model.Audio;
import com.example.uee_recipe_management.application.settings.model.RingingTone;
import com.example.uee_recipe_management.application.settings.model.customButton1;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CustomButtonSettings5 extends BaseAdapter {

    private Context context;
    ArrayList<Audio> list;
    TextView title1;
    private MediaPlayer mediaPlayer;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    public CustomButtonSettings5(Context context, ArrayList<Audio> list) {
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
            view = layoutInflater.inflate(R.layout.activity_custom_button_settings5 , null);
            firebaseDatabase = FirebaseDatabase.getInstance("https://uee-recipe-management-default-rtdb.asia-southeast1.firebasedatabase.app/");
            databaseReference = firebaseDatabase.getReference("Audio");

           title1 = (TextView) view.findViewById(R.id.settings5title1);
//            cardView = (CardView) view.findViewById(R.id.custombuttonsettings4);

            final Audio customButton1 = list.get(i);

            String name1 = customButton1.getTitle();
            title1.setText(name1);

//            mediaPlayer=MediaPlayer.create(getActivity().getApplicationContext(),R.raw.music1);
//            mediaPlayer.start();


//            view.setOnTouchListener(new View.OnTouchListener() {
//                @Override
//                public boolean onTouch(View view, MotionEvent motionEvent) {
//                    System.out.println("fffff");
//                    cardView.setCardBackgroundColor(Color.parseColor("#488747"));
//                    return true;
//                }
//            });

        }
        return view;
    }
}