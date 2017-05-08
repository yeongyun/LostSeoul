package com.y.md.lostseoul.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.y.md.lostseoul.adapter.contract.MainPagerAdapterContract;
import com.y.md.lostseoul.fragment.LostFragment;

/**
 * Created by prompt32 on 2017-05-02.
 */

public class MainPagerAdapter extends FragmentPagerAdapter implements MainPagerAdapterContract.Model {

    String[] filterList;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return LostFragment.newInstance(filterList[position]);
    }

    @Override
    public int getCount() {
        return filterList != null ? filterList.length : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return filterList != null ? filterList[position] : null;
    }

    @Override
    public void setData(String[] filters) {
        filterList = filters;
        notifyDataSetChanged();
    }

}
