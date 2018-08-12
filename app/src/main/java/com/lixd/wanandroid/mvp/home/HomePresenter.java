package com.lixd.wanandroid.mvp.home;

import com.lixd.wanandroid.data.BannerData;
import com.lixd.wanandroid.data.ClassifyDetailData;
import com.lixd.wanandroid.data.source.HomeRepository;
import com.lixd.wanandroid.net.rx.CustomEasyObserver;
import com.lixd.wanandroid.util.schedulers.BaseSchedulerProvider;
import com.lixd.wanandroid.util.schedulers.SchedulerProvider;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

public class HomePresenter implements HomeContact.Presenter {
    private final HomeContact.View mView;
    private final HomeRepository mHomeRepository;
    private final CompositeDisposable mCompositeDisposable;
    private final BaseSchedulerProvider mSchedulerProvider;

    public HomePresenter(HomeContact.View view, HomeRepository homeRepository) {
        mView = view;
        mView.setPresenter(this);
        mHomeRepository = homeRepository;
        mCompositeDisposable = new CompositeDisposable();
        mSchedulerProvider = SchedulerProvider.getInstance();
    }

    @Override
    public void getHomeData(int page) {
        mCompositeDisposable.add(
                mHomeRepository.getHomeArticle(page)
                        .subscribeOn(mSchedulerProvider.io())
                        .observeOn(mSchedulerProvider.ui())
                        .subscribeWith(new CustomEasyObserver<ClassifyDetailData>() {
                            @Override
                            protected void onSuccess(ClassifyDetailData data) {
                                if (data.curPage > data.pageCount) {
                                    //没有更多数据了
                                    return;
                                }
                                if (data.curPage == 0) {
                                    mView.showHomeData(data.datas);
                                } else {
                                    mView.showMoreHomeData(data.datas);
                                }
                            }

                            @Override
                            protected void onError(int code, String msg) {
                                mView.showError(msg);
                            }
                        }));
    }

    @Override
    public void getBanner() {
        mCompositeDisposable.add(
                mHomeRepository.getBanner()
                        .subscribeOn(mSchedulerProvider.io())
                        .observeOn(mSchedulerProvider.ui())
                        .subscribeWith(new CustomEasyObserver<List<BannerData>>() {
                            @Override
                            protected void onSuccess(List<BannerData> data) {
                                mView.showBannerData(data);
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
