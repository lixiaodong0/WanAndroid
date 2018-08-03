package com.lixd.wanandroid.mvp.auth.login;

import com.lixd.wanandroid.data.UserData;
import com.lixd.wanandroid.mvp.BasePresenter;
import com.lixd.wanandroid.mvp.BaseView;

public interface LoginContract {

    interface View extends BaseView<LoginContract.Presenter> {
        void loginSuccess(UserData data);

        void loginError(String msg);

        void onNetworkError();
    }

    interface Presenter extends BasePresenter {
        void login(String userName, String password);
    }
}
