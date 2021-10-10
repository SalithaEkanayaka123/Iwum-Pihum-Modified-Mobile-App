package com.example.uee_recipe_management.application.bookmark.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.bookmark.model.RecipieItem;

import java.util.List;

public class ItemTestingAdapter extends RecyclerView.Adapter<ItemTestingAdapter.ViewHolder> {

    List<String> titles;
    List<Integer> images;
    LayoutInflater inflater;

    public ItemTestingAdapter(Context ctx, List<String> titles, List<Integer> images) {
        this.titles = titles;
        this.images = images;
        this.inflater = LayoutInflater.from(ctx);
    }

    @NonNull
    @Override
    public ItemTestingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recipie_card_item_new, parent, false);
        return new ItemTestingAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemTestingAdapter.ViewHolder holder, int position) {
        holder.title.setText(titles.get(position));
        holder.gridIcon.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        ImageView gridIcon;
        ImageButton fvrt_btn;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTv);
            description = itemView.findViewById(R.id.descriptionTv);
            gridIcon = itemView.findViewById(R.id.bannerIv);
            fvrt_btn = itemView.findViewById(R.id.fvrt_f2_item);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Clicked -> " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}