package com.lixd.wanandroid.mvp.home;

import android.view.View;

import com.lixd.wanandroid.R;
import com.lixd.wanandroid.base.BaseFragment;

public class HomeFragment extends BaseFragment {

    public static final String TAG = HomeFragment.class.getSimpleName();

    public static final HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    protected Object getLayout() {
        return R.layout.home_fragmnet;
    }

    @Override
    protected void initView(View rootView) {

    }
}
