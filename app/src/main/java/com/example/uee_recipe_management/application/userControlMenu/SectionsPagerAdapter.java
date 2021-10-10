package com.example.uee_recipe_management.application.userControlMenu;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.uee_recipe_management.application.userControlMenu.Fragments.AddFragment;

import java.util.ArrayList;
import java.util.List;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFrags = new ArrayList<>();

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFrags.get(position);
    }
    @Override
    public int getCount() {
        return mFrags.size();
    }
    public void addtoFragment( Fragment fragment) {
        mFrags.add(fragment);
    }

}
