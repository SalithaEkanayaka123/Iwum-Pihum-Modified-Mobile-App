package com.example.uee_recipe_management.category.category.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uee_recipe_management.category.category.model.CategoryItem;

import java.util.List;

public class CategoryItemAdapter extends RecyclerView.Adapter<CategoryItemAdapter.CategoryItemViewHolder> {
    private Context context;
    private List<CategoryItem> categoryItemList;


    @NonNull
    @Override
    public CategoryItemViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull  CategoryItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
       return categoryItemList.size();
    }

    public static final class CategoryItemViewHolder extends RecyclerView.ViewHolder{

        public CategoryItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
