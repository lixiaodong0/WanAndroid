package com.lixd.wanandroid.mvp.auth;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.transition.Slide;
import android.view.Gravity;

import com.lixd.wanandroid.R;
import com.lixd.wanandroid.base.BaseActivity;
import com.lixd.wanandroid.data.source.LoginRepository;
import com.lixd.wanandroid.data.source.RegisterRepository;
import com.lixd.wanandroid.data.source.local.LoginLocalDataSource;
import com.lixd.wanandroid.data.source.remote.LoginRemoteDataSource;
import com.lixd.wanandroid.data.source.remote.RegisterRemoteDataSource;
import com.lixd.wanandroid.mvp.auth.login.LoginFragment;
import com.lixd.wanandroid.mvp.auth.login.LoginPresenter;
import com.lixd.wanandroid.mvp.auth.register.RegisterFragment;
import com.lixd.wanandroid.mvp.auth.register.RegisterPresenter;

public class AuthActivity extends BaseActivity {

    private LoginFragment mLoginFragment;
    private RegisterFragment mRegisterFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.contianer_activity;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        super.initData(savedInstanceState);
        if (savedInstanceState != null) {
            //回显fragment状态
            mLoginFragment = (LoginFragment) getSupportFragmentManager().getFragment(savedInstanceState, LoginFragment.TAG);
            mRegisterFragment = (RegisterFragment) getSupportFragmentManager().getFragment(savedInstanceState, RegisterFragment.TAG);
        } else {
            mLoginFragment = LoginFragment.newInstance();
            mRegisterFragment = RegisterFragment.newInstance();
        }

        FragmentManager manager = getSupportFragmentManager();
        if (!mLoginFragment.isAdded()) {
            manager.beginTransaction()
                    .add(R.id.frame_contianer, mLoginFragment, LoginFragment.TAG)
                    .commit();
        }
        if (!mRegisterFragment.isAdded()) {
            manager.beginTransaction()
                    .add(R.id.frame_contianer, mRegisterFragment, RegisterFragment.TAG)
                    .commit();
        }

        new LoginPresenter(mLoginFragment,
                LoginRepository.getInstance(new LoginLocalDataSource(), new LoginRemoteDataSource()));
        new RegisterPresenter(mRegisterFragment,
                RegisterRepository.getInstance(new RegisterRemoteDataSource()));

        if (!mLoginFragment.isHidden()) {
            showLoginFragment();
        } else if (!mRegisterFragment.isHidden()) {
            showRegisterFragment();
        } else {
            //默认显示登录页面
            showLoginFragment();
        }
    }

    public void showLoginFragment() {

        getSupportFragmentManager()
                .beginTransaction()
                .show(mLoginFragment)
                .hide(mRegisterFragment)
                .commit();
    }

    public void showRegisterFragment() {
        Slide registerSlide = new Slide();
        //        registerSlide.setInterpolator(new AccelerateDecelerateInterpolator());
        registerSlide.setSlideEdge(Gravity.RIGHT);
        mRegisterFragment.setEnterTransition(registerSlide);
        mRegisterFragment.setExitTransition(registerSlide);
        mRegisterFragment.setAllowEnterTransitionOverlap(true);
        mRegisterFragment.setAllowReturnTransitionOverlap(true);

        Slide loginSlide = new Slide();
        loginSlide.setSlideEdge(Gravity.LEFT);
        //        loginSlide.setInterpolator(new AccelerateDecelerateInterpolator());
        mLoginFragment.setEnterTransition(loginSlide);
        mLoginFragment.setExitTransition(loginSlide);
        mLoginFragment.setAllowEnterTransitionOverlap(true);
        mLoginFragment.setAllowReturnTransitionOverlap(true);

        getSupportFragmentManager()
                .beginTransaction()
                .show(mRegisterFragment)
                .hide(mLoginFragment)
                .commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //当横竖屏切换的时候,保存fragment状态
        FragmentManager manager = getSupportFragmentManager();
        if (mLoginFragment.isAdded()) {
            manager.putFragment(outState, LoginFragment.TAG, mLoginFragment);
        }
        if (mRegisterFragment.isAdded()) {
            manager.putFragment(outState, RegisterFragment.TAG, mRegisterFragment);
        }
    }
}
