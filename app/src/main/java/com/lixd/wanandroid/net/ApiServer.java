package com.lixd.wanandroid.net;

import com.lixd.wanandroid.data.BannerData;
import com.lixd.wanandroid.data.BaseData;
import com.lixd.wanandroid.data.ClassifyData;
import com.lixd.wanandroid.data.ClassifyDetailData;
import com.lixd.wanandroid.data.TreeData;
import com.lixd.wanandroid.data.UserData;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiServer {

    /**
     * 用户登录
     *
     * @param username 用户名称
     * @param password 密码
     */
    @FormUrlEncoded
    @POST("user/login")
    Observable<BaseData<UserData>> login(@Field("username") String username,
                                         @Field("password") String password);

    /**
     * 用户注册
     *
     * @param username   用户名称
     * @param password   密码
     * @param repassword 二次密码
     */
    @FormUrlEncoded
    @POST("user/register")
    Observable<BaseData<UserData>> register(@Field("username") String username,
                                            @Field("password") String password,
                                            @Field("repassword") String repassword);

    /**
     * 获取首页banner图数据
     */
    @GET("banner/json")
    Observable<List<BannerData>> getBanner();

    /**
     * 获取首页文章
     *
     * @param page 页数
     * @return
     */
    @GET("article/list/{page}/json")
    Observable<BaseData<ClassifyDetailData>> getHomeArticle(@Path("page") int page);

    /**
     * 获取体系数据列表
     *
     * @return
     */
    @GET("tree/json")
    Observable<BaseData<List<TreeData>>> getTreeList();

    /**
     * 获取体系数据列表详情数据
     *
     * @return
     */
    @GET("article/list/{page}/json")
    Observable<BaseData<ClassifyDetailData>> getTreeDetail(@Path("page") int page, @Query("cid") int cid);

    /***
     * 获取目前搜索最多的关键词。
     */
    @GET("hotkey/json")
    Observable<ResponseBody> getHotkey();

    /**
     * 获取项目分类数据
     */
    @GET("project/tree/json")
    Observable<BaseData<List<ClassifyData>>> getProjectClassify();

    /**
     * 获取项目分类详情数据
     */
    @GET("project/list/{page}/json")
    Observable<BaseData<ClassifyDetailData>> getProjectClassifyDetail(@Path("page") int page, @Query("cid") int cid);


}
