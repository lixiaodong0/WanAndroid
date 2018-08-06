package com.lixd.wanandroid.mvp.project;

import com.lixd.wanandroid.data.ClassifyData;
import com.lixd.wanandroid.data.source.ProjectClassifyDataSource;
import com.lixd.wanandroid.net.rx.CustomEasyObserver;
import com.lixd.wanandroid.util.schedulers.BaseSchedulerProvider;
import com.lixd.wanandroid.util.schedulers.SchedulerProvider;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;

public class ProjectClassifyPresenter implements ProjectClassifyContract.Presenter {
    private final ProjectClassifyContract.View mView;
    private final ProjectClassifyDataSource mDataSource;
    private final CompositeDisposable mCompositeDisposable;
    private final BaseSchedulerProvider mSchedulerProvider = SchedulerProvider.getInstance();

    public ProjectClassifyPresenter(ProjectClassifyContract.View view, ProjectClassifyDataSource dataSource) {
        mView = view;
        mView.setPresenter(this);
        mDataSource = dataSource;
        mCompositeDisposable = new CompositeDisposable();
    }


    @Override
    public void subscribe() {
        getProjectClassifyData();
    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void getProjectClassifyData() {
        mDataSource.getProjectClassifyData()
                .map(new Function<List<ClassifyData>, List<ClassifyData>>() {
                    @Override
                    public List<ClassifyData> apply(List<ClassifyData> classifyData) throws Exception {
                        //将第一条数据设置为选中
                        if (classifyData != null && classifyData.size() > 0) {
                            classifyData.get(0).isSelected = true;
                        }
                        return classifyData;
                    }
                })
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribeWith(new CustomEasyObserver<List<ClassifyData>>() {

                    @Override
                    protected void onSuccess(List<ClassifyData> data) {
                        mView.showProjectClassifyData(data);
                    }

                    @Override
                    protected void onError(int code, String msg) {
                        mView.showError(msg);
                    }
                });
    }
}
