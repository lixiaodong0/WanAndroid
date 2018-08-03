package com.lixd.wanandroid.mvp.auth.register;

import com.lixd.wanandroid.data.UserData;
import com.lixd.wanandroid.mvp.BasePresenter;
import com.lixd.wanandroid.mvp.BaseView;

public interface RegisterContract {

    interface View extends BaseView<RegisterContract.Presenter> {
        void registerSuccess(UserData data);

        void registerError(String msg);

        void onNetworkError();
    }

    interface Presenter extends BasePresenter {
        void register(String userName, String password, String repasswrod);
    }
}
