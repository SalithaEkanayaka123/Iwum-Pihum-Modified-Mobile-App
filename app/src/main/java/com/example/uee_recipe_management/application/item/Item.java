package com.example.uee_recipe_management.application.item;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.example.uee_recipe_management.application.item.adapter.ItemAdapter;
import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.item.adapter.SimilarItem;
import com.example.uee_recipe_management.application.item.adapter.SingleItemGridAdapter;
import com.example.uee_recipe_management.application.bookmark.adapter.SliderAdapter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Item extends AppCompatActivity {

    SliderView sliderView; //
    int[] images = {R.drawable.img_1, R.drawable.img_2, R.drawable.img_3,};
    ListView listView;
    TextView listText;
    Toolbar toolbar;
    RecyclerView similarItemsRecycler;

    RecyclerView dataMethods;
    List<String> titles;
    List<String> description;
    ItemAdapter itemAdapter;

    //Array With Dummy values, This should be passed to from the item model class
            /**
             *  Reminder
             *  Refactor the model class and the item ingredients arraylist there. And pass to the
             *  This Activity.
             *
             * **/
    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};

    ArrayList<String> array = new ArrayList<String>();
    ArrayList<SimilarItem> similarItemsArray = new ArrayList<SimilarItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item2);

        // Toolbar should be androidx version.
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        //Registering the Image Slider.
        sliderView = findViewById(R.id.image_slider);
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();
        toolbar = findViewById(R.id.tool_bar);
        similarItemsRecycler = findViewById(R.id.single_view_recycler);

        //Removing the header title from the Toolbar.
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);

        //Setting the data set to the List view (Ingredients)
        listView = findViewById(R.id.single_item_list_view);
        listText = findViewById(R.id.single_item_header);

        //Adding Items to the Array.
        array.add("Butter");
        array.add("Sugar");
        array.add("Vanilla");
        array.add("Cherry");

        //Adding Items to the Similar Item Array.
        similarItemsArray.add(new SimilarItem("Cherry Vine", "Drinks", R.drawable.image_4));
        similarItemsArray.add(new SimilarItem("Fried Rice", "Main Course", R.drawable.image_5));
        similarItemsArray.add(new SimilarItem("Cake", "Sweets", R.drawable.image_6));
        similarItemsArray.add(new SimilarItem("Coca Cola", "Drinks", R.drawable.image_7));

        //Calling the Grid Single Item Adapter method.
        setSimilarItems(similarItemsArray);


        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.single_view_list, R.id.single_ingred_name, array);
        listView.setAdapter(adapter);
        setListViewHeightBasedOnChildren(listView);

        dataMethods = findViewById(R.id.data_method);

        titles = new ArrayList<>();
        description = new ArrayList<>();

        titles.add("1");
        titles.add("2");
        titles.add("3");

        description.add("This is a description");
        description.add("This is a description");
        description.add("This is a description");


        itemAdapter = new ItemAdapter(this,titles,description);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        dataMethods.setLayoutManager(gridLayoutManager);
        dataMethods.setAdapter((RecyclerView.Adapter) itemAdapter);


    }

    // Dynamically expand the ListView based on the Item count.
    public static void setListViewHeightBasedOnChildren(ListView myListView) {
        ListAdapter adapter = myListView.getAdapter();
        if (myListView != null) {
            int totalHeight = 0;
            for (int i = 0; i < adapter.getCount(); i++) {
                View item= adapter.getView(i, null, myListView);
                item.measure(0, 0);
                totalHeight += item.getMeasuredHeight();
            }

            ViewGroup.LayoutParams params = myListView.getLayoutParams();
            params.height = totalHeight + (myListView.getDividerHeight() * (adapter.getCount() - 1));
            myListView.setLayoutParams(params);
        }
    }

    //Applying the Similar grid items to the Recycler View.
    public  void setSimilarItems(ArrayList<SimilarItem> similarItems){
        SingleItemGridAdapter adapter = new SingleItemGridAdapter(this, similarItems);
        similarItemsRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        similarItemsRecycler.setAdapter(adapter);
    }
}