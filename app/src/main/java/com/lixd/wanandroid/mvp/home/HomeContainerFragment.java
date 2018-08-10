package com.lixd.wanandroid.mvp.home;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.lixd.wanandroid.R;
import com.lixd.wanandroid.adapter.HomeViewPagerAdapter;
import com.lixd.wanandroid.base.BaseFragment;
import com.lixd.wanandroid.data.TabData;

import java.util.ArrayList;
import java.util.List;

public class HomeContainerFragment extends BaseFragment {

    public static final String TAG = HomeContainerFragment.class.getSimpleName();
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private HomeViewPagerAdapter mPagerAdapter;

    public static final HomeContainerFragment newInstance() {
        HomeContainerFragment fragment = new HomeContainerFragment();
        return fragment;
    }

    @Override
    protected Object getLayout() {
        return R.layout.home_container_fragmnet;
    }

    @Override
    protected void initView(View rootView) {
        mTabLayout = rootView.findViewById(R.id.home_tab_layout);
        mViewPager = rootView.findViewById(R.id.home_view_pager);
        String[] tabArray = getActivity().getResources().getStringArray(R.array.home_tab_layout_array);
        List<TabData> dataList = new ArrayList<>();
        dataList.add(new TabData(HomeFragment.newInstance(), tabArray[0]));
        dataList.add(new TabData(SystemFragment.newInstance(), tabArray[1]));
        mPagerAdapter = new HomeViewPagerAdapter(getChildFragmentManager(), dataList);
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
