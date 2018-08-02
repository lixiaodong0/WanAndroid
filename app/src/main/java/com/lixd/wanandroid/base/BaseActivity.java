package com.lixd.wanandroid.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

public abstract class BaseActivity extends AppCompatActivity {

    protected LayoutInflater mLayoutInflater;
    protected Context mActContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActContext = this;
        mLayoutInflater = LayoutInflater.from(this);
        setContentView(getLayoutId());
        initView();
        initData(savedInstanceState);
        initEvent();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected void initData(Bundle savedInstanceState) {}

    protected void initEvent() {}

}
