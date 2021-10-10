package com.example.uee_recipe_management.application.userControlMenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.example.uee_recipe_management.application.NavgationController;
import com.example.uee_recipe_management.application.R;
import com.example.uee_recipe_management.application.bookmark.ItemTestingFragment;
import com.example.uee_recipe_management.application.userControlMenu.Fragments.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;


public class UserControlMenu extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    NavgationController Nav = new NavgationController();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_control_menu);

        ///////////////////////
        BottomNavigationView bottomNavView  = findViewById(R.id.bottom_nav);
        bottomNavView.setOnNavigationItemSelectedListener( navListener);

        Menu menu = bottomNavView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);
        ///////////////////////////

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
        adapter.addtoFragment( new ItemTestingFragment());
        adapter.addtoFragment( new BookmarkFragment());
        viewPager.setAdapter(adapter);

    }

    private  BottomNavigationView.OnNavigationItemSelectedListener navListener = new
            BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Intent change =  Nav.ChangeMainAcivty(item, UserControlMenu.this);
                    startActivity(change);
                    return true;
                }
            };
}