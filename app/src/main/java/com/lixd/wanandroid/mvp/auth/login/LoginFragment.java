package com.lixd.wanandroid.mvp.auth.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lixd.wanandroid.R;
import com.lixd.wanandroid.base.BaseFragment;
import com.lixd.wanandroid.data.UserData;
import com.lixd.wanandroid.mvp.auth.AuthActivity;

public class LoginFragment extends BaseFragment implements View.OnClickListener, LoginContract.View {
    public static final String TAG = LoginFragment.class.getSimpleName();

    private EditText mEditUserName;
    private EditText mEditPassword;
    private Button mBtnLogin;
    private TextView mTvToRegister;
    private LoginContract.Presenter mPresenter;


    public static final LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    protected Object getLayout() {
        return R.layout.login_fragment;
    }

    @Override
    protected void initView(View rootView) {
        mEditUserName = rootView.findViewById(R.id.edit_login_username);
        mEditPassword = rootView.findViewById(R.id.edit_login_password);
        mBtnLogin = rootView.findViewById(R.id.btn_login);
        mTvToRegister = rootView.findViewById(R.id.tv_login_to_register);
    }

    @Override
    protected void initEvent() {
        mBtnLogin.setOnClickListener(this);
        mTvToRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                login();
                break;
            case R.id.tv_login_to_register:
                toRegister();
                break;
        }
    }


    private void login() {
        String userName = mEditUserName.getText().toString().trim();
        String password = mEditPassword.getText().toString().trim();
        mPresenter.login(userName, password);
    }

    private void toRegister() {
        AuthActivity activity = (AuthActivity) getActivity();
        activity.showRegisterFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @Override
    public void loginSuccess(UserData data) {
        Toast.makeText(getContext(), "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onNetworkError() {

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
