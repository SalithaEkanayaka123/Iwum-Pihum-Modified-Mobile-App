package com.example.uee_recipe_management.application.category.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.category.CategorySearchLayout;
import com.example.uee_recipe_management.application.category.model.AllCategories;
import com.example.uee_recipe_management.application.category.model.CategoryItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class CategoriesRecyclerAdapter extends RecyclerView.Adapter<CategoriesRecyclerAdapter.MainViewHolder>{
    private Context context;
    private List<AllCategories> allCategoriesList;
    private static List<CategoryItem> categoryItems;

    public CategoriesRecyclerAdapter(Context context, List<AllCategories> allCategories){
        this.context = context;
        this.allCategoriesList = allCategories;
    }

    public static List<CategoryItem> getCategoryItems(){
        return categoryItems;
    }

    public Context getContext(){
        return context;
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
        ImageView moreButton;

        public MainViewHolder(View itemView){
            super(itemView);
            categoryName = itemView.findViewById(R.id.category_section_header);
            itemRecycleView = itemView.findViewById(R.id.category_section_scroll);
            moreButton = itemView.findViewById(R.id.section_more_button);
            /**
             * Add a listener to the arrow icon on the header section and pass the item list when navigate to the fragment.
             * **/
            moreButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ArrayList<CategoryItem> items = (ArrayList<CategoryItem>) getCategoryItems();
                    Intent intent = new Intent(view.getContext(), CategorySearchLayout.class);
                    Bundle args = new Bundle();
                    args.putParcelableArrayList("ARRAYLIST", items);
                    intent.putExtras(args);
                    intent.putExtra("categoryName", categoryName.getText().toString());
                    view.getContext().startActivity(intent);
                }
            });
        }
    }

    private void setCategoryItemRecycler(RecyclerView recyclerView, List<CategoryItem> categoryItems){
        this.categoryItems = categoryItems;
        CategoryItemAdapter itemRecyclerAdapter = new CategoryItemAdapter(context, categoryItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(itemRecyclerAdapter);
    }
}
