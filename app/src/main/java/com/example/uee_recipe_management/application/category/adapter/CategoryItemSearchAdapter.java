package com.example.uee_recipe_management.application.category.adapter;

import android.content.Context;
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

import java.util.ArrayList;
import java.util.List;

public class CategoryItemSearchAdapter extends RecyclerView.Adapter<CategoryItemSearchAdapter.SearchViewHolder> {
    private Context context;
    private List<CategoryItem> categorySearchItemList;

    // Constructor
    public CategoryItemSearchAdapter(Context context, List<CategoryItem> categorySearchItemList) {
        this.context = context;
        this.categorySearchItemList = categorySearchItemList;
    }

    // Getters and Setters


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<CategoryItem> getCategorySearchItemList() {
        return categorySearchItemList;
    }

    public void setCategorySearchItemList(List<CategoryItem> categorySearchItemList) {
        this.categorySearchItemList = categorySearchItemList;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new SearchViewHolder(LayoutInflater.from(context).inflate(R.layout.long_card_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.longCardHeader.setText(categorySearchItemList.get(position).getName());
        holder.longCardSubHeading.setText(categorySearchItemList.get(position).getName());
        holder.longCardDescription.setText(categorySearchItemList.get(position).getDescription());
        holder.longCardImageView.setImageResource(categorySearchItemList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return categorySearchItemList.size();
    }

    public void filterList(ArrayList<CategoryItem> filteredList){
        categorySearchItemList = filteredList;
        notifyDataSetChanged();
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

            longCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("Clicking on the "+ longCardHeader.getText().toString());
                }
            });
        }
    }
}
