package com.lixd.wanandroid.data;

import com.lixd.wanandroid.base.BaseFragment;

public class TabData {
    public BaseFragment fragment;
    public String title;

    public TabData(BaseFragment fragment, String title) {
        this.fragment = fragment;
        this.title = title;
    }
}
