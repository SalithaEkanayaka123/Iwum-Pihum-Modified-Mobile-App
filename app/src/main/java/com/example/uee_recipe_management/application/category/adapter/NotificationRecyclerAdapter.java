package com.example.uee_recipe_management.application.category.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
    private ArrayList<NotificationModel> notifications;

    public NotificationRecyclerAdapter(Context context, ArrayList<NotificationModel> list) {
        this.context = context;
        this.notifications = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view;
        if(viewType == TYPE_NEW){
            view = LayoutInflater.from(context).inflate(R.layout.notification_layout_row_new, parent, false);
            return new NewViewHolder(view);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.notification_layout_row_read, parent, false);
            return new ReadViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(notifications.get(position).getType().contains("NEW")){
            return TYPE_NEW;
        } else {
            return TYPE_READ;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == TYPE_NEW) {
           ((NewViewHolder) holder).setNewNotificationDetails(notifications.get(position));
        } else {
            ((ReadViewHolder) holder).setReadNotificationDetails(notifications.get(position));
        }
    }

    @Override
    public int getItemCount() {
       return notifications.size();
    }

    class NewViewHolder extends RecyclerView.ViewHolder {

        TextView Header;
        TextView SubHeader;

        public NewViewHolder( View itemView) {
            super(itemView);
            Header = itemView.findViewById(R.id.new_notification_header);
            SubHeader = itemView.findViewById(R.id.new_notification_subheader);
        }

        public void setNewNotificationDetails(NotificationModel model) {
           Header.setText(model.getName());
           SubHeader.setText(model.getSubheading());
        }
    }

    class ReadViewHolder extends RecyclerView.ViewHolder {

        TextView Header;
        TextView SubHeader;

        public ReadViewHolder( View itemView) {
            super(itemView);
            Header = itemView.findViewById(R.id.read_notification_header);
            SubHeader = itemView.findViewById(R.id.read_notification_subheader);
        }

        public void setReadNotificationDetails(NotificationModel model) {
            Header.setText(model.getName());
            SubHeader.setText(model.getSubheading());
        }
    }
}
