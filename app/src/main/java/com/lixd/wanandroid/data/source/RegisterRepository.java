package com.lixd.wanandroid.data.source;

import com.lixd.wanandroid.data.UserData;

import io.reactivex.Observable;

public class RegisterRepository implements RegisterDataSource {
    private static RegisterRepository INSTANCE;
    private RegisterDataSource mRegisterRemoteDataSource;

    private RegisterRepository(RegisterDataSource registerRemoteDataSource) {
        mRegisterRemoteDataSource = registerRemoteDataSource;
    }


    public static final RegisterRepository getInstance(RegisterDataSource registerRemoteDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new RegisterRepository(registerRemoteDataSource);
        }
        return INSTANCE;
    }


    @Override
    public Observable<UserData> register(String username, String password, String repassword) {
        return mRegisterRemoteDataSource.register(username, password, repassword);
    }
}
