package com.lixd.wanandroid.data.source;

import android.support.annotation.NonNull;

import com.lixd.wanandroid.data.UserData;

import io.reactivex.Observable;

public class LoginRepository implements LoginDataSource {

    private static LoginRepository INSTANCE;
    private LoginDataSource mLoginLocalDataSource;
    private LoginDataSource mLoginRemoteDataSource;

    private LoginRepository(LoginDataSource loginLocalDataSource, LoginDataSource loginRemoteDataSource) {
        mLoginLocalDataSource = loginLocalDataSource;
        mLoginRemoteDataSource = loginRemoteDataSource;
    }

    public static final LoginRepository getInstance(@NonNull LoginDataSource loginLocalDataSource,
                                                    LoginDataSource loginRemoteDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new LoginRepository(loginLocalDataSource, loginRemoteDataSource);
        }
        return INSTANCE;
    }

    @Override
    public Observable<UserData> getLocalLoginData(int userId) {
        if (mLoginLocalDataSource != null) {
            return mLoginLocalDataSource.getLocalLoginData(userId);
        }
        return null;
    }

    @Override
    public Observable<UserData> getRemoteLoginData(String username, String password) {
        return mLoginRemoteDataSource.getRemoteLoginData(username, password);
    }
}
