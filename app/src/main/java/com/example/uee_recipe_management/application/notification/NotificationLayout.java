package com.example.uee_recipe_management.application.notification;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.uee_recipe_management.application.NavgationController;
import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.category.adapter.NotificationRecyclerAdapter;
import com.example.uee_recipe_management.application.category.model.NotificationModel;
import com.example.uee_recipe_management.application.home.Home;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class NotificationLayout extends AppCompatActivity {

    RecyclerView notificationRecycler;
    NotificationRecyclerAdapter notificationRecyclerAdapter;
    ArrayList<NotificationModel> notifications;
    NavgationController Nav = new NavgationController();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_layout);

        //Bottom Nav Configs
        BottomNavigationView bottomNavView  = findViewById(R.id.bottom_nav);
        bottomNavView.setOnNavigationItemSelectedListener( navListener);
        Menu menu = bottomNavView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

        notifications = new ArrayList<>();

        // Create dummy notifications
        notifications.add(new NotificationModel("Update Available 5.5v", "Bug Fixed", "NEW"));
        notifications.add(new NotificationModel("Update Available 5.5v", "Bug Fixed", "READ"));
        notifications.add(new NotificationModel("Update Available 5.5v", "Bug Fixed", "NEW"));
        notifications.add(new NotificationModel("Update Available 5.5v", "Bug Fixed", "READ"));
        notifications.add(new NotificationModel("Update Available 5.5v", "Bug Fixed", "NEW"));
        notifications.add(new NotificationModel("Update Available 5.5v", "Bug Fixed", "NEW"));
        notifications.add(new NotificationModel("Update Available 5.5v", "Bug Fixed", "NEW"));
        notifications.add(new NotificationModel("Update Available 5.5v", "Bug Fixed", "READ"));
        notifications.add(new NotificationModel("Update Available 5.5v", "Bug Fixed", "READ"));
        notifications.add(new NotificationModel("Update Available 5.5v", "Bug Fixed", "READ"));
        setRecyclerNotifications();
    }

    private void setRecyclerNotifications() {
        notificationRecycler = findViewById(R.id.notification_recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        notificationRecycler.setLayoutManager(layoutManager);
        notificationRecyclerAdapter = new NotificationRecyclerAdapter(this, notifications);
        notificationRecycler.setAdapter(notificationRecyclerAdapter);
    }

    private  BottomNavigationView.OnNavigationItemSelectedListener navListener = new
            BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Intent change =  Nav.ChangeMainAcivty(item, NotificationLayout.this);
                    startActivity(change);
                    return true;
                }
    };
}