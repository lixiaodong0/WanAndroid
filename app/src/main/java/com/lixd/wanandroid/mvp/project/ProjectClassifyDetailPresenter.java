package com.lixd.wanandroid.mvp.project;

import com.lixd.wanandroid.data.ArticleData;
import com.lixd.wanandroid.data.ClassifyDetailData;
import com.lixd.wanandroid.data.source.ProjectClassifyPepository;
import com.lixd.wanandroid.net.rx.CustomEasyObserver;
import com.lixd.wanandroid.util.schedulers.BaseSchedulerProvider;
import com.lixd.wanandroid.util.schedulers.SchedulerProvider;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;

public class ProjectClassifyDetailPresenter implements ProjectClassifyDetailContract.Presenter {
    private final ProjectClassifyDetailContract.View mView;
    private final ProjectClassifyPepository mDataSource;
    private final BaseSchedulerProvider mSchedulerProvider;
    private final CompositeDisposable mCompositeDisposable;

    public ProjectClassifyDetailPresenter(ProjectClassifyDetailContract.View view, ProjectClassifyPepository dataSource) {
        mView = view;
        mView.setPresenter(this);
        mDataSource = dataSource;
        mSchedulerProvider = SchedulerProvider.getInstance();
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getProjectClassifyDetail(int page, int cid) {
        mCompositeDisposable.add(
                mDataSource.getProjectClassifyDetailData(page, cid)
                        .flatMap(new Function<ClassifyDetailData, ObservableSource<List<ArticleData>>>() {
                            @Override
                            public ObservableSource<List<ArticleData>> apply(ClassifyDetailData classifyDetailData) throws Exception {
                                return Observable.just(classifyDetailData.datas);
                            }
                        })
                        .subscribeOn(mSchedulerProvider.io())
                        .observeOn(mSchedulerProvider.ui())
                        .subscribeWith(new CustomEasyObserver<List<ArticleData>>() {
                            @Override
                            protected void onSuccess(List<ArticleData> data) {
                                mView.showProjectClassifyDetail(data);
                            }

                            @Override
                            protected void onError(int code, String msg) {
                                mView.showError(msg);
                            }
                        }));

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }
}
