package com.lixd.wanandroid.data.source;

import com.lixd.wanandroid.data.UserData;

import io.reactivex.Observable;

public interface RegisterDataSource {

    Observable<UserData> register(String username, String password,String repassword);
}
