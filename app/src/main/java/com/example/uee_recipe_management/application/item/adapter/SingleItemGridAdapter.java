package com.example.uee_recipe_management.application.item.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uee_recipe_management.application.R;

import java.util.List;

public class SingleItemGridAdapter extends RecyclerView.Adapter<SingleItemGridAdapter.MyViewHolder> {
   private Context context;
   private List<SimilarItem> similarItemList;

   public SingleItemGridAdapter(Context context, List<SimilarItem> similarItems){
      this.context = context;
      this.similarItemList = similarItems;
   }


   @Override
   public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view;
      LayoutInflater mInflater = LayoutInflater.from(context);
      view = mInflater.inflate(R.layout.single_item_grid_item, parent,false);
      return new MyViewHolder(view);
   }

   @Override
   public void onBindViewHolder(SingleItemGridAdapter.MyViewHolder holder, int position) {
      holder.imageView.setImageResource(similarItemList.get(position).getThumbnail());
      holder.header.setText(similarItemList.get(position).getName());
      holder.subheader.setText(similarItemList.get(position).getSubheader());
      holder.cardView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Toast.makeText(context, "Clicked on the CardView", Toast.LENGTH_SHORT).show();
         }
      });
   }

   @Override
   public int getItemCount() {
      return similarItemList.size();
   }

   public static class MyViewHolder extends RecyclerView.ViewHolder {

      CardView cardView;
      TextView header;
      TextView subheader;
      ImageView imageView;


      public MyViewHolder(View itemView) {
         super(itemView);

         cardView = (CardView) itemView.findViewById(R.id.cardview_grid_item);
         header = (TextView) itemView.findViewById(R.id.grid_item_header);
         subheader = (TextView) itemView.findViewById(R.id.grid_item_subheader);
         imageView = (ImageView) itemView.findViewById(R.id.image_grid_item);
      }
   }
}
