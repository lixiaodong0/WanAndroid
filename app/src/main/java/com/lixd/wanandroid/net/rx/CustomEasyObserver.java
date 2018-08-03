package com.lixd.wanandroid.net.rx;

import com.lixd.wanandroid.net.exception.ServerException;

import io.reactivex.observers.DisposableObserver;

public abstract class CustomEasyObserver<T> extends DisposableObserver<T> {

    @Override
    public void onNext(T data) {
        onSuccess(data);
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof ServerException) {
            ServerException serverException = (ServerException) e;
            onError(serverException.errorCode, serverException.errorMsg);
        } else {
            onError(-10086, "网络或服务器异常");
        }
    }

    @Override
    public void onComplete() {

    }

    protected abstract void onSuccess(T data);

    protected abstract void onError(int code, String msg);

}
