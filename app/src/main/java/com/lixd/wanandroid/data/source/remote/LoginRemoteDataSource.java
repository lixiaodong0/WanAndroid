package com.lixd.wanandroid.data.source.remote;

import com.lixd.wanandroid.data.UserData;
import com.lixd.wanandroid.data.source.LoginDataSource;
import com.lixd.wanandroid.net.ApiServer;
import com.lixd.wanandroid.net.RetrofitClient;
import com.lixd.wanandroid.net.rx.ServerFunction;

import io.reactivex.Observable;

public class LoginRemoteDataSource implements LoginDataSource {

    @Override
    public Observable<UserData> getLocalLoginData(int userId) {
        return null;
    }

    @Override
    public Observable<UserData> getRemoteLoginData(final String username, String password) {
        return RetrofitClient.getInstance()
                .create(ApiServer.class)
                .login(username, password)
                .flatMap(new ServerFunction<UserData>());
    }
}
