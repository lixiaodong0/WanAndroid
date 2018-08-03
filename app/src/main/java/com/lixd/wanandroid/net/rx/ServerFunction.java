package com.lixd.wanandroid.net.rx;

import com.lixd.wanandroid.data.BaseData;
import com.lixd.wanandroid.net.exception.ServerException;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class ServerFunction<T> implements Function<BaseData<T>, ObservableSource<T>> {

    @Override
    public ObservableSource<T> apply(BaseData<T> bsaeData) throws Exception {
        if (bsaeData.errorCode != 0) {
            //业务异常
            throw new ServerException(bsaeData.errorCode, bsaeData.errorMsg);
        }
        return Observable.just(bsaeData.data);
    }
}
