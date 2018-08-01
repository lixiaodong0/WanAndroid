package com.lixd.wanandroid.util.schedulers;

import io.reactivex.Scheduler;

public interface BaseSchedulerProvider {

    Scheduler io();

    Scheduler ui();
}
