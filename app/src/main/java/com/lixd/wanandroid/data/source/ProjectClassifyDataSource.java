package com.lixd.wanandroid.data.source;

import com.lixd.wanandroid.data.ClassifyData;
import com.lixd.wanandroid.data.ClassifyDetailData;

import java.util.List;

import io.reactivex.Observable;

public interface ProjectClassifyDataSource {

    Observable<List<ClassifyData>> getProjectClassifyData();

    Observable<List<ClassifyDetailData>> getProjectClassifyDetailData(int page, int cid);

}
