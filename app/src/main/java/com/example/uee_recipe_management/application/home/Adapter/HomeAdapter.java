package com.example.uee_recipe_management.application.home.Adapter;

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
import com.example.uee_recipe_management.application.category.adapter.CategoryItemSearchAdapter;
import com.example.uee_recipe_management.application.category.model.CategoryItem;
import com.example.uee_recipe_management.application.home.model.HistoryItem;
import com.example.uee_recipe_management.application.item.Item;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.SearchViewHolder> {

    private Context context;
    private List<CategoryItem> HomeItemList;
    DatabaseReference mDatabaseRef;

    public HomeAdapter() {
    }


    public HomeAdapter(Context context, List<CategoryItem> homeItemList, DatabaseReference mDataRef) {
        this.context = context;
        HomeItemList = homeItemList;
        mDatabaseRef = mDataRef;

    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<CategoryItem> getHomeItemList() {
        return HomeItemList;
    }

    public void setHomeItemList(List<CategoryItem> homeItemList) {
        HomeItemList = homeItemList;
    }

    public DatabaseReference getmDatabaseRef() {
        return mDatabaseRef;
    }

    public void setmDatabaseRef(DatabaseReference mDatabaseRef) {
        this.mDatabaseRef = mDatabaseRef;
    }


    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeAdapter.SearchViewHolder(LayoutInflater.from(context).inflate(R.layout.long_card_layout, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {

        Uri myUri = null;
        holder.longCardHeader.setText(HomeItemList.get(position).getName());
        holder.longCardSubHeading.setText(HomeItemList.get(position).getSubName());
        holder.longCardDescription.setText(HomeItemList.get(position).getDescription());

        //////////////////////////////////////////////////////////  getting the single item click event ///////////////////
        holder.longCardView.setOnClickListener(new View.OnClickListener() {
            CategoryItem cI = new CategoryItem(holder.longCardHeader.getText().toString(),
                    "",
                    holder.longCardSubHeading.getText().toString(),
                    holder.longCardDescription.getText().toString(),
                    "");
            @Override
            public void onClick(View view) {
                System.out.println(" || ++++++++++++++++++++++++ || " +cI);
//                    String value = getRef(position).getKey();
                addItemsToHistory(cI);

                Intent intent = new Intent(view.getContext(), Item.class);
                view.getContext().startActivity(intent);
            }
        });///
        /////////////////////////////////////////////////////////////
        try {
            myUri = Uri.parse(HomeItemList.get(position).getFireURL());
            Picasso.with(getContext()).load(myUri).into(holder.longCardImageView);

        } catch (Exception e){
            System.out.println(" || Exception HomeItemAdapter || " + e.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return HomeItemList.size();
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

        }
    }


    ////////////////////////////Firebase add method/////////////////////////////////

    public void addItemsToHistory (CategoryItem cI ) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String x = formatter.format(date);

        HistoryItem hI = new HistoryItem(cI.getName(),cI.getFireURL(),cI.getDescription(),cI.getSubName(),cI.getCategory(),x);
        String uploadId = mDatabaseRef.push().getKey();
        mDatabaseRef.child(uploadId).setValue(hI).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                System.out.println("======================================================");
                System.out.println("============================ Done ====================");
                System.out.println("======================================================");

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                System.out.println("======================================================");
                e.printStackTrace();
            }
        });
    }
}
