package com.example.uee_recipe_management.category.category.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uee_recipe_management.category.R;
import com.example.uee_recipe_management.category.category.model.AllCategories;
import com.example.uee_recipe_management.category.category.model.CategoryItem;

import java.util.List;

public class CategoryItemAdapter extends RecyclerView.Adapter<CategoryItemAdapter.CategoryItemViewHolder> {
    private Context context;
    private List<CategoryItem> categoryItemList;

    public CategoryItemAdapter(Context context, List<CategoryItem> categoryItemList){
        this.context = context;
        this.categoryItemList = categoryItemList;
    }

    @NonNull
    @Override
    public CategoryItemViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new CategoryItemViewHolder(LayoutInflater.from(context).inflate(R.layout.card_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull  CategoryItemViewHolder holder, int position) {

        holder.bannerTv.setImageResource(categoryItemList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
       return categoryItemList.size();
    }

    public static final class CategoryItemViewHolder extends RecyclerView.ViewHolder{

        ImageView bannerTv;
        TextView titleTv;
        TextView descriptionTv;
        TextView dateTv;

        public CategoryItemViewHolder(View itemView) {
            super(itemView);
            bannerTv = itemView.findViewById(R.id.bannerIv);
            titleTv = itemView.findViewById(R.id.titleTv);
            descriptionTv = itemView.findViewById(R.id.descriptionTv);
            dateTv = itemView.findViewById(R.id.dateTv);

        }
    }
}
