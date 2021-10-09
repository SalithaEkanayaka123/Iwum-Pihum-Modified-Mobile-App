package com.example.uee_recipe_management.application.settings.CustomButtonSettings;

import android.Manifest;
import android.content.Context;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.settings.model.customButton1;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.SQLOutput;
import java.util.ArrayList;


public class CustomButtonSettings extends BaseAdapter {

    private Context context;
    ArrayList<customButton1> list;
    TextView title1, title2;
    Switch toogleButton;
    CardView longCardView;
    ListView listView1;
    Vibrator vibrator;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

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
            title1 = (TextView) view.findViewById(R.id.settingstitle1);
            title2 = (TextView) view.findViewById(R.id.settingstitle2);
            listView1 = (ListView) view.findViewById(R.id.listSettings11);
            vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
            final long [] pattern = {2000, 10000};

            firebaseDatabase = FirebaseDatabase.getInstance("https://uee-recipe-management-default-rtdb.asia-southeast1.firebasedatabase.app/");
            databaseReference = firebaseDatabase.getReference("Notification").child("1");

            toogleButton = view.findViewById(R.id.switch1);
            longCardView = view.findViewById(R.id.cardSettingsId1);
            final customButton1 customButton1 = list.get(i);//i means relevent adapter position
            //songList(i) means we are geting the relevent array value of ArrayList<SongList> at postion i

            String name1 = customButton1.getTitle1();
            title1.setText(name1);
            String name2 = customButton1.getTitle2();
            title2.setText(name2);

            //needed to be updated
            toogleButton.setChecked(true);
            View finalView = view;
            toogleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                   if (name1.contentEquals("Notification")){
                       System.out.println("notification");
                       if (b == true){
                           databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                               @Override
                               public void onDataChange(@NonNull DataSnapshot snapshot) {
                                   databaseReference.child("status").setValue(true);
                                   Snackbar.make(finalView,"Successful notification on...!!!",Snackbar.LENGTH_LONG).show();
                               }

                               @Override
                               public void onCancelled(@NonNull DatabaseError error) {
                                   Snackbar.make(finalView,"Error...!!!",Snackbar.LENGTH_LONG).show();
                               }
                           });

                       }else  if (b == false){
                           databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                               @Override
                               public void onDataChange(@NonNull DataSnapshot snapshot) {
                                   databaseReference.child("status").setValue(false);
                                   Snackbar.make(finalView,"Successfuly notification off...!!!",Snackbar.LENGTH_LONG).show();
                               }

                               @Override
                               public void onCancelled(@NonNull DatabaseError error) {
                                   Snackbar.make(finalView,"Error...!!!",Snackbar.LENGTH_LONG).show();
                               }
                           });
//                           Toast.makeText(context, "Notification off", Toast.LENGTH_SHORT).show();
                       }
                   }else if (name1.contentEquals("Dark Mode")){
                       System.out.println("Dark Mode");
                       if (b == true){
                           Snackbar.make(finalView,"Dark mode on",Snackbar.LENGTH_LONG).show();
                           AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                       }else  if (b == false){
                           AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                           Snackbar.make(finalView,"Dark mode off",Snackbar.LENGTH_LONG).show();
                       }
                   }else if (name1.contentEquals("Vibration")){
                       System.out.println("Vibration " + b);
                       if (b == true){
                           vibrator.vibrate(pattern, 0);
                           System.out.println("Vibration 1");
                           Snackbar.make(finalView,"vibrator on",Snackbar.LENGTH_LONG).show();
                       }else  if (b == false){
                            vibrator.cancel();
                           Snackbar.make(finalView,"vibrator off",Snackbar.LENGTH_LONG).show();
                           System.out.println("Vibration 2");
                       }
                   }else if (name1.contentEquals("Sync")){
                       System.out.println("Sync");
                       if (b == true){
                           Snackbar.make(finalView,"Synchronization on",Snackbar.LENGTH_LONG).show();
                       }else  if (b == false){
                           Snackbar.make(finalView,"Synchronization off",Snackbar.LENGTH_LONG).show();
                       }
                   }
                   else if (name1.contentEquals("Sync on startup")){
                       System.out.println("Sync on startup");
                       if (b == true){
                           Snackbar.make(finalView,"Synchronizing on startup",Snackbar.LENGTH_LONG).show();
                       }else  if (b == false){
                           Snackbar.make(finalView,"Synchronizing on startup",Snackbar.LENGTH_LONG).show();
                           Toast.makeText(context, "Synchronization off", Toast.LENGTH_SHORT).show();
                       }
                   }
                }
            });
            //customButton1 item = list.get(i);
//            listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                    System.out.println("ggg " + i);
//                }
//            });
//            if(customButton1.getStatus()){
//                //toggle your switch.
//            }


//            longCardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    System.out.println("cassss");
//                }
//            });




        }
        return view;
    }
}