package com.lixd.wanandroid.data.source;

import com.lixd.wanandroid.data.BannerData;
import com.lixd.wanandroid.data.ClassifyDetailData;

import java.util.List;

import io.reactivex.Observable;

public class HomeRepository implements HomeDataSource {
    public static HomeRepository INSTANCE;
    private HomeDataSource mRemote;

    private HomeRepository(HomeDataSource remote) {
        mRemote = remote;
    }

    public static final HomeRepository getInstance(HomeDataSource remote) {
        if (INSTANCE == null) {
            INSTANCE = new HomeRepository(remote);
        }
        return INSTANCE;
    }

    @Override
    public Observable<List<BannerData>> getBanner() {
        return mRemote.getBanner();
    }

    @Override
    public Observable<ClassifyDetailData> getHomeArticle(int page) {
        return mRemote.getHomeArticle(page);
    }
}
