package com.lixd.wanandroid.mvp;

import java.io.Serializable;

public interface BasePresenter extends Serializable {
    void subscribe();

    void unsubscribe();
}
