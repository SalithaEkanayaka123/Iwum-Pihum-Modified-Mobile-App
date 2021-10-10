package com.example.uee_recipe_management.application.bookmark.adapter;

import android.content.Context;
import android.net.Uri;
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
import com.example.uee_recipe_management.application.bookmark.ItemTesting;
import com.example.uee_recipe_management.application.bookmark.model.RecipieItem;
import com.example.uee_recipe_management.application.category.model.CategoryItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ItemTestingAdapter extends RecyclerView.Adapter<ItemTestingAdapter.ViewHolder> {

    ArrayList<RecipieItem> arrayList;
    LayoutInflater inflater;
    private Context context;
    public ItemTestingAdapter(Context ctx, ArrayList<RecipieItem> arrayList) {
        this.arrayList = arrayList;
        this.inflater = LayoutInflater.from(ctx);
        this.context = ctx;
    }

    public ItemTestingAdapter() {

    }

    @NonNull
    @Override
    public ItemTestingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recipie_card_item_new, parent, false);
        return new ItemTestingAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemTestingAdapter.ViewHolder holder, int position) {

        Uri myUri = null;

        try {
            holder.title.setText(arrayList.get(position).getName());
            holder.description.setText(arrayList.get(position).getDescription());
            myUri = Uri.parse(arrayList.get(position).getFireURL());
            Picasso.with(context).load(myUri).into(holder.gridIcon);
        } catch (Exception e){
            System.out.println("Exception | CategoryItemSearchAdapter | - " + e.getMessage());
        }


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public void filterList(ArrayList<RecipieItem> filteredList){
        arrayList = filteredList;
        notifyDataSetChanged();
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

            //call listner
        }
    }
}