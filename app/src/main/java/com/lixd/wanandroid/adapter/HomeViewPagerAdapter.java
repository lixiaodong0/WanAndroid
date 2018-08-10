package com.lixd.wanandroid.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lixd.wanandroid.data.TabData;

import java.util.List;

public class HomeViewPagerAdapter extends FragmentPagerAdapter {
    private List<TabData> mDatas;

    public HomeViewPagerAdapter(FragmentManager fm, List<TabData> datas) {
        super(fm);
        mDatas = datas;
    }

    @Override
    public Fragment getItem(int position) {
        return mDatas.get(position).fragment;
    }

    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mDatas.get(position).title;
    }
}
