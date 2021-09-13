package com.example.uee_recipe_management.category.category.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uee_recipe_management.category.R;
import com.example.uee_recipe_management.category.category.model.AllCategories;
import com.example.uee_recipe_management.category.category.model.CategoryItem;

import java.util.List;

public class CategoriesRecyclerAdapter extends RecyclerView.Adapter<CategoriesRecyclerAdapter.MainViewHolder>{
    private Context context;
    private List<AllCategories> allCategoriesList;

    public CategoriesRecyclerAdapter(Context context, List<AllCategories> allCategories){
        this.context = context;
        this.allCategoriesList = allCategories;
    }


    @Override
    public MainViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.category_section, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull  CategoriesRecyclerAdapter.MainViewHolder holder, int position) {
        holder.categoryName.setText(allCategoriesList.get(position).getCategoryName());
        setCategoryItemRecycler(holder.itemRecycleView, allCategoriesList.get(position).getCategoryItems());
    }

    @Override
    public int getItemCount() {
       return allCategoriesList.size();
    }

    public static final class MainViewHolder extends RecyclerView.ViewHolder {

        TextView categoryName;
        RecyclerView itemRecycleView;

        public MainViewHolder(View itemView){
            super(itemView);
            categoryName = itemView.findViewById(R.id.category_section_header);
            itemRecycleView = itemView.findViewById(R.id.category_section_scroll);
            /**
             * Add a listener to the arrow icon on the header section and pass the item list when navigate to the fragment.
             * **/
        }
    }

    private void setCategoryItemRecycler(RecyclerView recyclerView, List<CategoryItem> categoryItems){
        CategoryItemAdapter itemRecyclerAdapter = new CategoryItemAdapter(context, categoryItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(itemRecyclerAdapter);
    }
}
