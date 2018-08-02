package com.lixd.wanandroid.mvp.outh.login;

import com.lixd.wanandroid.mvp.BasePresenter;
import com.lixd.wanandroid.mvp.BaseView;

public interface LoginContract {

    interface View extends BaseView<LoginContract.Presenter> {
        void loginSuccess();

        void onNetworkError();
    }

    interface Presenter extends BasePresenter {
        void login(String userName, String password);
    }
}
