package com.lixd.wanandroid.mvp.project;

import com.lixd.wanandroid.data.ClassifyData;
import com.lixd.wanandroid.mvp.BasePresenter;
import com.lixd.wanandroid.mvp.BaseView;

import java.util.List;

public interface ProjectClassifyContract {

    interface View extends BaseView<Presenter> {

        void showProjectClassifyData(List<ClassifyData> data);

        void showError(String msg);
    }

    interface Presenter extends BasePresenter {
        void getProjectClassifyData();
    }
}
