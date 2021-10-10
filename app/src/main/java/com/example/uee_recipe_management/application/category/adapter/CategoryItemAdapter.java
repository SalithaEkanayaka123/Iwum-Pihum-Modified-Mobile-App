package com.example.uee_recipe_management.application.category.adapter;

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
import com.example.uee_recipe_management.application.bookmark.firebaseImageUploading.Upload;
import com.example.uee_recipe_management.application.category.model.CategoryItem;
import com.example.uee_recipe_management.application.item.Item;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

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
        Uri myUri = null;
        try {
            myUri = Uri.parse(categoryItemList.get(position).getFireURL());
            Picasso.with(context).load(myUri).into(holder.bannerTv);
        } catch (Exception e){
            System.out.println("Exception | CategoryItemSearchAdapter | - " + e.getMessage());
        }
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
        CardView smallCardItem;

        public CategoryItemViewHolder(View itemView) {
            super(itemView);
            bannerTv = itemView.findViewById(R.id.bannerIv);
            titleTv = itemView.findViewById(R.id.titleTv);
            descriptionTv = itemView.findViewById(R.id.descriptionTv);
            dateTv = itemView.findViewById(R.id.dateTv);
            smallCardItem = itemView.findViewById(R.id.small_card_layout_card);

            smallCardItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("Click on the " + titleTv.getText().toString());
                    Intent intent = new Intent(view.getContext(), Item.class);
                    view.getContext().startActivity(intent);
                }
            });
        }

    }
}
