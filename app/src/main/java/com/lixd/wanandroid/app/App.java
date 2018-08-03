package com.lixd.wanandroid.app;

import android.app.Application;
import android.content.Context;

import com.lixd.wanandroid.BuildConfig;
import com.lixd.wanandroid.util.LogUtil;

public class App extends Application {

    public static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
        LogUtil.init(BuildConfig.DEBUG);
    }
}
