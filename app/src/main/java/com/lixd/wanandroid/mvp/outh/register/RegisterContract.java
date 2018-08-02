package com.lixd.wanandroid.mvp.outh.register;

import com.lixd.wanandroid.mvp.BasePresenter;
import com.lixd.wanandroid.mvp.BaseView;

public interface RegisterContract {

    interface View extends BaseView<RegisterContract.Presenter> {
        void onRegisterSuccess();

        void onNetworkError();
    }

    interface Presenter extends BasePresenter {
        void register(String userName, String password, String repasswrod);
    }
}
