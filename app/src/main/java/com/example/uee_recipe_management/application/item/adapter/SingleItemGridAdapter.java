package com.example.uee_recipe_management.application.item.adapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
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
      return null;
   }

   @Override
   public void onBindViewHolder(SingleItemGridAdapter.MyViewHolder holder, int position) {

   }

   @Override
   public int getItemCount() {
      return 0;
   }

   public static class MyViewHolder extends RecyclerView.ViewHolder {

      public MyViewHolder(View itemView) {
         super(itemView);
      }
   }
}
