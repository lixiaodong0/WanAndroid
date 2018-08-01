package com.lixd.wanandroid.net;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServer {

    /**
     * 用户登录
     *
     * @param userName 用户名称
     * @param password 密码
     */
    @FormUrlEncoded
    @POST("user/login")
    Observable<ResponseBody> login(@Field("userName") String userName,
                                   @Field("password") String password);

    /**
     * 用户注册
     *
     * @param userName   用户名称
     * @param password   密码
     * @param repassword 二次密码
     */
    @FormUrlEncoded
    @POST("user/register")
    Observable<ResponseBody> register(@Field("userName") String userName,
                                      @Field("password") String password,
                                      @Field("repassword") String repassword);

    /**
     * 获取首页banner图数据
     */
    @GET("banner/json")
    Observable<ResponseBody> getBanner();

    /***
     * 获取目前搜索最多的关键词。
     */
    @GET("hotkey/json")
    Observable<ResponseBody> getHotkey();
}
