package com.example.callphone.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.callphone.fragments.ContactFragment;
import com.example.callphone.fragments.FavoritesFragment;
import com.example.callphone.fragments.RecentFragment;

public class PhoneAdapter extends FragmentPagerAdapter {


    private int numOfTabs;

    public PhoneAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int pos) {
        switch (pos) {
            case 0:
                return new FavoritesFragment();
            case 1:
                return new RecentFragment();
            case 2:
                return new ContactFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
