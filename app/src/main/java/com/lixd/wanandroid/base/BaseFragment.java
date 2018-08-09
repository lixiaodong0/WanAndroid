package com.lixd.wanandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Object layout = getLayout();
        if (layout == null) {
            throw new NullPointerException("getLayout() not null");
        } else if (layout instanceof Integer) {
            View rootView = inflater.inflate((Integer) layout, container, false);
            initView(rootView);
            initData(savedInstanceState);
            initEvent();
            return rootView;
        } else if (layout instanceof View) {
            View rootView = (View) layout;
            initView(rootView);
            initData(savedInstanceState);
            initEvent();
            return rootView;
        } else {
            throw new RuntimeException("getLayout()类型只能是Integer,View类型");
        }
    }


    protected abstract Object getLayout();

    protected abstract void initView(View rootView);

    protected void initData(Bundle savedInstanceState) {}

    protected void initEvent() {}
}
