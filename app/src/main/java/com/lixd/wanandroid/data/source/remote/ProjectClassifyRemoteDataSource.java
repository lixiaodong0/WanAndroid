package com.lixd.wanandroid.data.source.remote;

import com.lixd.wanandroid.data.ClassifyData;
import com.lixd.wanandroid.data.ClassifyDetailData;
import com.lixd.wanandroid.data.source.ProjectClassifyDataSource;
import com.lixd.wanandroid.net.ApiServer;
import com.lixd.wanandroid.net.RetrofitClient;
import com.lixd.wanandroid.net.rx.ServerFunction;

import java.util.List;

import io.reactivex.Observable;

public class ProjectClassifyRemoteDataSource implements ProjectClassifyDataSource {
    @Override
    public Observable<List<ClassifyData>> getProjectClassifyData() {
        return RetrofitClient.getInstance().create(ApiServer.class)
                .getProjectClassify()
                .flatMap(new ServerFunction<List<ClassifyData>>());
    }

    @Override
    public Observable<ClassifyDetailData> getProjectClassifyDetailData(int page, int cid) {
        return RetrofitClient.getInstance().create(ApiServer.class)
                .getProjectClassifyDetail(page, cid)
                .flatMap(new ServerFunction<ClassifyDetailData>());
    }
}
