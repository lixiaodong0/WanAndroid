package com.lixd.wanandroid.mvp.recreation;

import android.view.View;

import com.lixd.wanandroid.R;
import com.lixd.wanandroid.base.BaseFragment;

public class RecreationFragment extends BaseFragment {
    public static final String TAG = RecreationFragment.class.getSimpleName();

    public static final RecreationFragment newInstance() {
        RecreationFragment fragment = new RecreationFragment();
        return fragment;
    }

    @Override
    protected Object getLayout() {
        return R.layout.recreation_fragment;
    }

    @Override
    protected void initView(View rootView) {

    }
}
