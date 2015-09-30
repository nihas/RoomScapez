package com.room.scapez.adapter;

/**
 * Created by snyxius on 9/29/2015.
 */
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.room.scapez.fragments.TabOneFragment;
import com.room.scapez.fragments.TabThreeFragment;
import com.room.scapez.fragments.TabTwoFragment;
import com.room.scapez.pojos.AmenitiesPojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp1 on 21-01-2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence Titles[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created
    List<AmenitiesPojo> amenites;


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumbOfTabsumb, ArrayList<AmenitiesPojo> amenitiesList) {
        super(fm);

        this.Titles = mTitles;
        this.NumbOfTabs = mNumbOfTabsumb;
        this.amenites=amenitiesList;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if(position == 0) // if the position is 0 we are returning the First tab
        {
            TabOneFragment tab1 = TabOneFragment.newInstance(amenites);
            return tab1;
        }
        else if(position == 1)            // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            TabTwoFragment tab2 = TabTwoFragment.newInstance(amenites);
            return tab2;
        }else{
            TabThreeFragment tab3 = TabThreeFragment.newInstance(amenites);
            return tab3;
        }


    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs;
    }
}
