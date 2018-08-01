package com.lixd.wanandroid.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private RetrofitClient() {
    }


    private static class RetrofitClientHelper {

        private static final OkHttpClient OK_HTTP_CLIENT =
                new OkHttpClient.Builder()
                        .readTimeout(Constants.READ_TIME_OUT, TimeUnit.SECONDS)
                        .connectTimeout(Constants.CONNECT_TIME_OUT, TimeUnit.SECONDS)
                        .writeTimeout(Constants.WRITE_TIME_OUT, TimeUnit.SECONDS)
                        .build();

        private static final Retrofit RETROFIT =
                new Retrofit.Builder()
                        .client(OK_HTTP_CLIENT)
                        .baseUrl(Constants.BASE_URL)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
    }

    public static final Retrofit getInstance() {
        return RetrofitClientHelper.RETROFIT;
    }

}
