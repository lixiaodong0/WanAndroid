package com.lixd.wanandroid.mvp.project;

import com.lixd.wanandroid.data.ArticleData;
import com.lixd.wanandroid.mvp.BasePresenter;
import com.lixd.wanandroid.mvp.BaseView;

import java.util.List;

public interface ProjectClassifyDetailContract {


    interface View extends BaseView<Presenter> {

        void showProjectClassifyDetail(List<ArticleData> data);

        void showError(String msg);
    }

    interface Presenter extends BasePresenter {
        void getProjectClassifyDetail(int page, int cid);
    }
}
