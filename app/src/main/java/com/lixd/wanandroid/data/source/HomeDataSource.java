package com.lixd.wanandroid.data.source;

import com.lixd.wanandroid.data.BannerData;
import com.lixd.wanandroid.data.ClassifyDetailData;

import java.util.List;

import io.reactivex.Observable;

public interface HomeDataSource {

    Observable<List<BannerData>> getBanner();

    Observable<ClassifyDetailData> getHomeArticle(int page);
}
