package com.example.uee_recipe_management.application.userControlMenu.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.category.model.CategoryItem;
import com.example.uee_recipe_management.application.home.model.HistoryItem;
import com.example.uee_recipe_management.application.item.Item;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.SearchViewHolder> {

    private Context context;
    private List<CategoryItem> HomeItemList;
    DatabaseReference mDatabaseRef;

    public HistoryAdapter() {
    }
    public HistoryAdapter(Context context, List<CategoryItem> homeItemList, DatabaseReference mDataRef) {
        this.context = context;
        HomeItemList = homeItemList;
        mDatabaseRef = mDataRef;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<CategoryItem> getHomeItemList() {
        return HomeItemList;
    }

    public void setHomeItemList(List<CategoryItem> homeItemList) {
        HomeItemList = homeItemList;
    }

    public DatabaseReference getmDatabaseRef() {
        return mDatabaseRef;
    }

    public void setmDatabaseRef(DatabaseReference mDatabaseRef) {
        this.mDatabaseRef = mDatabaseRef;
    }
    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HistoryAdapter.SearchViewHolder(LayoutInflater.from(context).inflate(R.layout.long_card_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {

        Uri myUri = null;
        holder.longCardHeader.setText(HomeItemList.get(position).getName());
        holder.longCardSubHeading.setText(HomeItemList.get(position).getSubName());
        holder.longCardDescription.setText(HomeItemList.get(position).getDescription());
        holder.longCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Item.class);
                view.getContext().startActivity(intent);
            }
        });///

        try {
            myUri = Uri.parse(HomeItemList.get(position).getFireURL());
            Picasso.with(getContext()).load(myUri).into(holder.longCardImageView);

        } catch (Exception e){
            System.out.println(" || Exception HomeItemAdapter || " + e.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return HomeItemList.size();
    }

    public static final class SearchViewHolder extends RecyclerView.ViewHolder {
        TextView longCardHeader;
        TextView longCardSubHeading;
        TextView longCardDescription;
        ImageView longCardImageView;
        CardView longCardView;
        public SearchViewHolder(View itemView) {
            super(itemView);
            longCardHeader = itemView.findViewById(R.id.lcard_title);
            longCardSubHeading = itemView.findViewById(R.id.lcard_second_title);
            longCardDescription = itemView.findViewById(R.id.lcard_description);
            longCardImageView = itemView.findViewById(R.id.lcard_image);
            longCardView = itemView.findViewById(R.id.long_card_view_item);

        }
    }

}
