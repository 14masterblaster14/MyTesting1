package com.example.a6universalnavigationdrawer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by ADMIN on 1/14/2018.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        //    return null;
        if (position == 0) {
            return new PrimaryFragment().getInstance();

        } else {
            return new SecondaryFragment().getInstance();
        }
    }

    @Override
    public int getCount() {
        //return 0;
        return 2;
    }
}
