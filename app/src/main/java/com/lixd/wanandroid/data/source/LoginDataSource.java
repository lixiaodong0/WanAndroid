package com.lixd.wanandroid.data.source;

import com.lixd.wanandroid.data.UserData;

import io.reactivex.Observable;


public interface LoginDataSource {

    Observable<UserData> getLocalLoginData(int userId);

    Observable<UserData> getRemoteLoginData(String username, String password);
}
