package com.lixd.wanandroid.data.source.remote;

import com.lixd.wanandroid.data.BannerData;
import com.lixd.wanandroid.data.ClassifyDetailData;
import com.lixd.wanandroid.data.source.HomeDataSource;
import com.lixd.wanandroid.net.ApiServer;
import com.lixd.wanandroid.net.RetrofitClient;
import com.lixd.wanandroid.net.rx.ServerFunction;

import java.util.List;

import io.reactivex.Observable;

public class HomeRemoteDataSource implements HomeDataSource {

    @Override
    public Observable<List<BannerData>> getBanner() {
        return RetrofitClient.getInstance()
                .create(ApiServer.class)
                .getBanner()
                .flatMap(new ServerFunction<List<BannerData>>());

    }

    @Override
    public Observable<ClassifyDetailData> getHomeArticle(int page) {
        return RetrofitClient.getInstance()
                .create(ApiServer.class)
                .getHomeArticle(page)
                .flatMap(new ServerFunction<ClassifyDetailData>());
    }
}
