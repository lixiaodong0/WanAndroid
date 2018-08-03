package com.lixd.wanandroid.mvp.auth.register;

import android.text.TextUtils;

import com.lixd.wanandroid.data.UserData;
import com.lixd.wanandroid.data.source.RegisterRepository;
import com.lixd.wanandroid.net.rx.CustomEasyObserver;
import com.lixd.wanandroid.util.schedulers.BaseSchedulerProvider;
import com.lixd.wanandroid.util.schedulers.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

public class RegisterPresenter implements RegisterContract.Presenter {

    private RegisterContract.View mRegisterView;
    private RegisterRepository mRegisterRepository;
    private final CompositeDisposable mCompositeDisposable;
    private final BaseSchedulerProvider mSchedulerProvider;

    public RegisterPresenter(RegisterContract.View view, RegisterRepository registerRepository) {
        mRegisterView = view;
        mRegisterView.setPresenter(this);
        mRegisterRepository = registerRepository;
        mCompositeDisposable = new CompositeDisposable();
        mSchedulerProvider = SchedulerProvider.getInstance();
    }

    @Override
    public void register(String userName, String password, String repasswrod) {
        if (!checkValidity(userName, password, repasswrod)) {
            return;
        }
        mCompositeDisposable.add(
                mRegisterRepository.register(userName, password, repasswrod)
                        .subscribeOn(mSchedulerProvider.io())
                        .observeOn(mSchedulerProvider.ui())
                        .subscribeWith(new CustomEasyObserver<UserData>() {
                            @Override
                            protected void onSuccess(UserData data) {
                                mRegisterView.registerSuccess(data);
                            }

                            @Override
                            protected void onError(int code, String msg) {
                                mRegisterView.registerError(msg);
                            }
                        }));

    }

    private boolean checkValidity(String username, String password, String repasswrod) {
        if (TextUtils.isEmpty(username)) {
            mRegisterView.registerError("用户名不能为空哦");
            return false;
        }

        if (TextUtils.isEmpty(password)) {
            mRegisterView.registerError("密码不能为空哦");
            return false;
        }

        if (TextUtils.isEmpty(repasswrod)) {
            mRegisterView.registerError("两次密码不能为空哦");
            return false;
        }

        if (username.length() < 6) {
            mRegisterView.registerError("用户名必须大于5位哦");
            return false;
        }

        if (password.length() < 6) {
            mRegisterView.registerError("密码必须大于5位哦");
            return false;
        }

        if (!password.equals(repasswrod)) {
            mRegisterView.registerError("两次输入密码不匹配哦");
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
