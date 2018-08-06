package com.lixd.wanandroid.data.source;

import com.lixd.wanandroid.data.ClassifyData;
import com.lixd.wanandroid.data.ClassifyDetailData;

import java.util.List;

import io.reactivex.Observable;

public class ProjectClassifyPepository implements ProjectClassifyDataSource {
    private static ProjectClassifyPepository INSTANCE;
    private ProjectClassifyDataSource mRemoteDataSource;

    private ProjectClassifyPepository(ProjectClassifyDataSource remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    public static final ProjectClassifyPepository getInstance(ProjectClassifyDataSource remoteDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new ProjectClassifyPepository(remoteDataSource);
        }
        return INSTANCE;
    }


    @Override
    public Observable<List<ClassifyData>> getProjectClassifyData() {
        return mRemoteDataSource.getProjectClassifyData();
    }

    @Override
    public Observable<ClassifyDetailData> getProjectClassifyDetailData(int page, int cid) {
        return mRemoteDataSource.getProjectClassifyDetailData(page, cid);
    }
}
