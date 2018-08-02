package com.lixd.wanandroid.data.source.local;

import com.lixd.wanandroid.data.UserData;
import com.lixd.wanandroid.data.source.LoginDataSource;

import io.reactivex.Observable;

public class LoginDataLocalSource implements LoginDataSource {
    @Override
    public Observable<UserData> getLocalLoginData(int userId) {
        return null;
    }

    @Override
    public Observable<UserData> getRemoteLoginData(String username, String password) {
        return null;
    }
}
