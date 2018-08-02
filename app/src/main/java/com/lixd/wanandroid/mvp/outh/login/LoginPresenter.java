package com.lixd.wanandroid.mvp.outh.login;

import io.reactivex.disposables.CompositeDisposable;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mLoginView;
    private final CompositeDisposable mCompositeDisposable;

    public LoginPresenter(LoginContract.View view) {
        mLoginView = view;
        mLoginView.setPresenter(this);
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void login(String userName, String password) {

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }
}
