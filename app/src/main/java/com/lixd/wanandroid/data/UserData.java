package com.lixd.wanandroid.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserData {
    /**
     * {
     * "data": {
     * "collectIds": [],
     * "email": "",
     * "icon": "",
     * "id": 8349,
     * "password": "it_lixd@163.com",
     * "type": 0,
     * "username": "lixiaodong0"
     * },
     * "errorCode": 0,
     * "errorMsg": ""
     * }
     */
    @SerializedName("collectIds")
    public List<Object> collectIds;
    @SerializedName("email")
    public String email;
    @SerializedName("icon")
    public String icon;
    @SerializedName("id")
    public int id;
    @SerializedName("password")
    public String password;
    @SerializedName("userName")
    public String userName;
    @SerializedName("type")
    public int type;
}
