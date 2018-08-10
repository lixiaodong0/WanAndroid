package com.lixd.wanandroid.data;

import com.google.gson.annotations.SerializedName;

public class BannerData {
    /**
     * "desc": "",
     * "id": 4,
     * "imagePath": "http://www.wanandroid.com/blogimgs/ab17e8f9-6b79-450b-8079-0f2287eb6f0f.png",
     * "isVisible": 1,
     * "order": 0,
     * "title": "看看别人的面经，搞定面试~",
     * "type": 1,
     * "url": "http://www.wanandroid.com/article/list/0?cid=73"
     */
    @SerializedName("desc")
    public String desc;
    @SerializedName("id")
    public int id;
    @SerializedName("imagePath")
    public String imagePath;
    @SerializedName("isVisible")
    public int isVisible;
    @SerializedName("order")
    public int order;
    @SerializedName("title")
    public String title;
    @SerializedName("type")
    public int type;
    @SerializedName("url")
    public String url;
}
