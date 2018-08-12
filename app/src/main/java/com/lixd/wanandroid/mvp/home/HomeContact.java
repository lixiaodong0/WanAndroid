package com.lixd.wanandroid.mvp.home;

import com.lixd.wanandroid.data.ArticleData;
import com.lixd.wanandroid.data.BannerData;
import com.lixd.wanandroid.mvp.BasePresenter;
import com.lixd.wanandroid.mvp.BaseView;

import java.util.List;

public interface HomeContact {

    interface View extends BaseView<Presenter> {

        void showBannerData(List<BannerData> data);

        void showHomeData(List<ArticleData> data);

        void showMoreHomeData(List<ArticleData> data);

        void showError(String msg);

        void showNetworkError();

        void showEmpty();
    }

    interface Presenter extends BasePresenter {

        void getHomeData(int page);

        void getBanner();
    }
}
