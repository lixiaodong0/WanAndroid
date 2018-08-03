package com.lixd.wanandroid.data.source.remote;

import com.lixd.wanandroid.data.UserData;
import com.lixd.wanandroid.data.source.RegisterDataSource;
import com.lixd.wanandroid.net.ApiServer;
import com.lixd.wanandroid.net.RetrofitClient;
import com.lixd.wanandroid.net.rx.ServerFunction;

import io.reactivex.Observable;

public class RegisterRemoteDataSource implements RegisterDataSource {
    private ApiServer apiServer = RetrofitClient.getInstance().create(ApiServer.class);

    @Override
    public Observable<UserData> register(String username, String password, String repassword) {
        return apiServer.register(username, password, repassword)
                .flatMap(new ServerFunction<UserData>());
    }
}
