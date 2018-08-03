package com.lixd.wanandroid.mvp.auth.login;

import android.text.TextUtils;

import com.lixd.wanandroid.data.UserData;
import com.lixd.wanandroid.data.source.LoginRepository;
import com.lixd.wanandroid.net.rx.CustomEasyObserver;
import com.lixd.wanandroid.util.schedulers.BaseSchedulerProvider;
import com.lixd.wanandroid.util.schedulers.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;


public class LoginPresenter implements LoginContract.Presenter {

    private final LoginContract.View mLoginView;
    private final LoginRepository mLoginRepository;
    private final CompositeDisposable mCompositeDisposable;
    private final BaseSchedulerProvider mSchedulerProvider;

    public LoginPresenter(LoginContract.View view, LoginRepository loginRepository) {
        mLoginView = view;
        mLoginView.setPresenter(this);
        mLoginRepository = loginRepository;
        mSchedulerProvider = SchedulerProvider.getInstance();
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void login(final String userName, String password) {
        if (!checkValidity(userName, password)) {
            return;
        }
        mCompositeDisposable.add(
                mLoginRepository.getRemoteLoginData(userName, password)
                        .subscribeOn(mSchedulerProvider.io())
                        .observeOn(mSchedulerProvider.ui())
                        .subscribeWith(new CustomEasyObserver<UserData>() {

                            @Override
                            protected void onSuccess(UserData data) {
                                mLoginView.loginSuccess(data);
                            }

                            @Override
                            protected void onError(int code, String msg) {
                                mLoginView.loginError(msg);
                            }
                        }));
    }


    private boolean checkValidity(String username, String password) {
        if (TextUtils.isEmpty(username)) {
            mLoginView.loginError("用户名不能为空哦");
            return false;
        }

        if (TextUtils.isEmpty(password)) {
            mLoginView.loginError("密码不能为空哦");
            return false;
        }

        if (username.length() < 6) {
            mLoginView.loginError("用户名必须大于5位哦");
            return false;
        }

        if (password.length() < 6) {
            mLoginView.loginError("密码必须大于5位哦");
            return false;
        }
        return true;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }
}
