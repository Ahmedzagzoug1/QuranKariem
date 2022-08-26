package com.zagzoug.qourankariem.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.zagzoug.qourankariem.QouranPagerFragment;

/**
 * Created by Ahmed on 4/2/2019.
 */

public class MViewPagerAdapter extends FragmentPagerAdapter {
int [] images;
    public MViewPagerAdapter(android.support.v4.app.FragmentManager fm,int[]images) {
        super(fm);
        this.images=images;
    }

    @Override
    public Fragment getItem(int position) {

        return QouranPagerFragment.newInstance( images[position]);
    }

    @Override
    public int getCount() {
         return images.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {

        }
        return null;
    }
}


