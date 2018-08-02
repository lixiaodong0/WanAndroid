package com.lixd.wanandroid.mvp.outh.register;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lixd.wanandroid.R;
import com.lixd.wanandroid.base.BaseFragment;
import com.lixd.wanandroid.mvp.outh.AuthActivity;

public class RegisterFragment extends BaseFragment implements View.OnClickListener, RegisterContract.View {
    public static final String TAG = RegisterFragment.class.getSimpleName();
    private EditText mEditUserName;
    private EditText mEditPassword;
    private EditText mEditRepassword;
    private Button mBtnRegister;
    private TextView mTvToLogin;
    private RegisterContract.Presenter mPresenter;

    public static final RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    @Override
    protected Object getLayout() {
        return R.layout.register_fragment;
    }

    @Override
    protected void initView(View rootView) {
        mEditUserName = rootView.findViewById(R.id.edit_register_username);
        mEditPassword = rootView.findViewById(R.id.edit_register_password);
        mEditRepassword = rootView.findViewById(R.id.edit_register_repassword);
        mBtnRegister = rootView.findViewById(R.id.btn_register);
        mTvToLogin = rootView.findViewById(R.id.tv_register_to_login);
    }

    @Override
    protected void initEvent() {
        mBtnRegister.setOnClickListener(this);
        mTvToLogin.setOnClickListener(this);
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                register();
                break;
            case R.id.tv_register_to_login:
                toLogin();
                break;
        }
    }


    private void register() {
        String userName = mEditUserName.getText().toString().trim();
        String password = mEditPassword.getText().toString().trim();
        String repassword = mEditRepassword.getText().toString().trim();
        mPresenter.register(userName, password, repassword);
    }

    private void toLogin() {
        AuthActivity activity = (AuthActivity) getActivity();
        activity.showLoginFragment();
    }

    @Override
    public void onRegisterSuccess() {

    }

    @Override
    public void onNetworkError() {

    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        mPresenter = presenter;
    }
}

