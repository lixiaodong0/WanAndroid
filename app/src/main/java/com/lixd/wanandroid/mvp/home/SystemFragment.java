package com.lixd.wanandroid.mvp.home;

import android.view.View;
import android.widget.TextView;

import com.lixd.wanandroid.R;
import com.lixd.wanandroid.base.BaseFragment;

public class SystemFragment extends BaseFragment {
    public static final String TAG = SystemFragment.class.getSimpleName();

    public static final SystemFragment newInstance() {
        SystemFragment fragment = new SystemFragment();
        return fragment;
    }

    @Override
    protected Object getLayout() {

        return R.layout.home_fragment;
    }

    @Override
    protected void initView(View rootView) {
        TextView textView = rootView.findViewById(R.id.tv_title);
        textView.setText("体系");
    }
}
