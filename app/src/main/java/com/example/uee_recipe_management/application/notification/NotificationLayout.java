package com.example.uee_recipe_management.application.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.category.adapter.NotificationRecyclerAdapter;
import com.example.uee_recipe_management.application.category.model.NotificationModel;

import java.util.ArrayList;

public class NotificationLayout extends AppCompatActivity {

    RecyclerView notificationRecycler;
    NotificationRecyclerAdapter notificationRecyclerAdapter;
    ArrayList<NotificationModel> notifications;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_layout);

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
}