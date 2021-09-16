package com.example.uee_recipe_management.application.category.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.category.model.NotificationModel;

import java.util.ArrayList;

/**
 * This is a multitype adapter class for displaying notifications.
 * */

public class NotificationRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static int TYPE_NEW = 1; // For new notifications
    private static int TYPE_READ = 2; // For read notifications
    private Context context;
    private ArrayList<NotificationRecyclerAdapter> notifications;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view;
        if(viewType == TYPE_NEW){
            view = LayoutInflater.from(context).inflate(R.layout.notification_layout_row_new, parent, false);
            return null; // Change once class created.
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.notification_layout_row_new, parent, false);
            return null; // Change once class created.
        }
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == TYPE_NEW) {
            // Update
        } else {
            // Update
        }
    }

    @Override
    public int getItemCount() {
       return notifications.size();
    }

    class NewViewHolder extends RecyclerView.ViewHolder {

        public NewViewHolder( View itemView) {
            super(itemView);
        }

        public void setNewNotificationDetails(NotificationModel model) {
            // Update the UI elements with model.
        }
    }

    class ReadViewHolder extends RecyclerView.ViewHolder {

        public ReadViewHolder( View itemView) {
            super(itemView);
        }

        public void setReadNotificationDetails(NotificationModel model) {
            // Update the UI elements with model.
        }
    }
}
