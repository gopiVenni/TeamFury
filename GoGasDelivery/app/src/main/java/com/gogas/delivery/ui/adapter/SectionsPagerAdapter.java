package com.gogas.delivery.ui.adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.gogas.delivery.ui.fragment.DeliveryFragment;
import com.gogas.delivery.ui.fragment.HistoryFragment;
import com.gogas.delivery.ui.fragment.TransactionFragment;


/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {


    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new DeliveryFragment();
                break;
            case 1:
                fragment = new HistoryFragment();
                break;
            case 2:
                fragment = new TransactionFragment();
                break;

        }
        return fragment;
    }


    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }
}