package com.example.uee_recipe_management.application.bookmark.adapter;

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
import com.example.uee_recipe_management.application.bookmark.model.RecipieItem;

import java.util.ArrayList;
import java.util.List;

public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.SearchViewHolder>{
    private Context context;
    private List<RecipieItem> recipieItems;

    // Constructor
    public BookmarkAdapter(Context context, ArrayList<RecipieItem> recipieItems) {
        this.context = context;
        this.recipieItems = recipieItems;
    }

    // Getters and Setters
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<RecipieItem> getRecipieItems() {
        return recipieItems;
    }

    public void setRecipieItems(List<RecipieItem> recipieItems) {
        this.recipieItems = recipieItems;
    }

    @NonNull
    @Override
    public BookmarkAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BookmarkAdapter.SearchViewHolder(LayoutInflater.from(context).inflate(R.layout.recipie_card_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BookmarkAdapter.SearchViewHolder holder, int position) {
        holder.longCardHeader.setText(recipieItems.get(position).getName());
        holder.longCardSubHeading.setText(recipieItems.get(position).getName());
        holder.longCardDescription.setText(recipieItems.get(position).getDescription());
        holder.longCardImageView.setImageResource(recipieItems.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return recipieItems.size();
    }

    public void filterList(ArrayList<RecipieItem> filteredList){
        recipieItems = filteredList;
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
