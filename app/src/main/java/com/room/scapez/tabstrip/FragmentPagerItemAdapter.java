/**
 * Copyright (C) 2015 ogaclejapan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.room.scapez.tabstrip;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.room.scapez.fragments.CityFragment;
//import com.room.scapez.fragments.ReviewsFragment;


public class FragmentPagerItemAdapter extends CacheFragmentStatePagerAdapter {

    private final FragmentPagerItems mPages;
    private int mScrollY;
    Fragment f;
    //private final SparseArrayCompat<WeakReference<Fragment>> mHolder;

    public FragmentPagerItemAdapter(FragmentManager fm,FragmentPagerItems pages) {
        super(fm);
        mPages = pages;
        //mHolder = new SparseArrayCompat<>(pages.size());
    }

    public void setScrollY(int scrollY) {
        mScrollY = scrollY;
    }



    private final String[] TITLES = { "Map", "Featured","Ratings","Ratings2","Ratings3"};

    @Override
    public int getCount() {
        return mPages.size();
    }



    @Override
    public Fragment getItem(int position) {
        //return getPagerItem(position).instantiate(mPages.getContext(), position);
        //return PageFragment.newInstance(position + 1);

        switch(position){
//            case 0:
//                return ReviewsFragment.newInstance(position + 1);
//
//            case 1:
//                return ReviewsFragment.newInstance(position + 1);
//            case 2:
//                return ReviewsFragment.newInstance(position + 1);
//            case 3:
//                return ReviewsFragment.newInstance(position + 1);
//            case 4:
//                return ReviewsFragment.newInstance(position + 1);

        }
        return null;
    }

    @Override
    protected Fragment createItem(int position) {

//        switch(position){
//            case 0:
//                f= new ReviewsFragment();
//
//            case 1:
//                f= new ReviewsFragment();
//            case 2:
//                f= new PageFragment();
//            case 3:
//                f= new ReviewsFragment();
//            case 4:
//                f= new ReviewsFragment();
//
//        }
        if (0 <= mScrollY) {
            Bundle args = new Bundle();
//            args.putInt(ReviewsFragment.ARG_SCROLL_Y, mScrollY);
            f.setArguments(args);
        }
        return f;
    }

//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        Object item = super.instantiateItem(container, position);
//        if (item instanceof Fragment) {
//            mHolder.put(position, new WeakReference<Fragment>((Fragment) item));
//        }
//        return item;
//    }
//
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        mHolder.remove(position);
//        super.destroyItem(container, position, object);
//    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];

    }


    @Override
    public float getPageWidth(int position) {
        return super.getPageWidth(position);
    }

//    public Fragment getPage(int position) {
//        final WeakReference<Fragment> weakRefItem = mHolder.get(position);
//        return (weakRefItem != null) ? weakRefItem.get() : null;
//    }
//
//    protected FragmentPagerItem getPagerItem(int position) {
//        return mPages.get(position);
//    }

}
