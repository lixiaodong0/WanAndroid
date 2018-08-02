package com.lixd.wanandroid.mvp.outh.register;

import io.reactivex.disposables.CompositeDisposable;

public class RegisterPresenter implements RegisterContract.Presenter {

    private RegisterContract.View mRegisterView;
    private final CompositeDisposable mCompositeDisposable;

    public RegisterPresenter(RegisterContract.View view) {
        mRegisterView = view;
        mRegisterView.setPresenter(this);
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void register(String userName, String password, String repasswrod) {

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }
}
