package com.example.uee_recipe_management.category;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.uee_recipe_management.category.CustomArrayList.CustomArrayList;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    //This import should be androidx
    private ActionBar actionBar;

    //Registering UI Views
    private ViewPager viewPage1;

    private ArrayList<MyModel> modelArrayList;
    private MyAdapter myAdapter1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init actionbar
        actionBar = getSupportActionBar();

        //init UI views
        viewPage1 = findViewById(R.id.viewPager);
        loadCards();

        //Set ViewPager Change Listener
        viewPage1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                String title = modelArrayList.get(position).getTitle();
                //actionBar.setTitle(title);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void loadCards() {
        //init list
        CustomArrayList array = CustomArrayList.getInstance();

        //Custom ArrayList
        modelArrayList = new ArrayList<>();
        modelArrayList.add(new MyModel("Android Image", "Description 01", "3/8/2020", R.drawable.image1));
        modelArrayList.add(new MyModel("Second Image", "Description 01", "3/8/2020",R.drawable.image2));
        modelArrayList.add(new MyModel("Third Image", "Description 01", "3/8/2020",R.drawable.image3));
        modelArrayList.add(new MyModel("Fourth Image", "Description 01", "3/8/2020",R.drawable.image4));
        modelArrayList.add(new MyModel("Fifth Image", "Description 01", "3/8/2020",R.drawable.image5));

        //Setting the adapter
        myAdapter1 = new MyAdapter(this, modelArrayList);
        //Set adapter to view page.
        viewPage1.setAdapter(myAdapter1);

        //Set Default padding from left/ right
        viewPage1.setPadding(100, 0, 100, 0);

    }

}