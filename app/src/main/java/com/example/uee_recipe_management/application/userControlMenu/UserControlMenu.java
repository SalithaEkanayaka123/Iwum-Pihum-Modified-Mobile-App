package com.example.uee_recipe_management.application.userControlMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;


import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.userControlMenu.Fragments.*;
import com.google.android.material.tabs.TabLayout;


public class UserControlMenu extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_control_menu);

        getSupportFragmentManager();

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.main_fragment_container);
        setUpViewPager(mViewPager);

        TabLayout tablayout =  (TabLayout) findViewById(R.id.tabs_controller);
        tablayout.setupWithViewPager(mViewPager);

        tablayout.getTabAt(0).setText("History");
        tablayout.getTabAt(1).setText("Your Recipes");
        tablayout.getTabAt(2).setText("Bookmarks");


    }

    private void setUpViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addtoFragment( new HistoryFragment());
        adapter.addtoFragment( new AddFragment());
        adapter.addtoFragment( new BookmarkFragment());
        viewPager.setAdapter(adapter);

    }
}