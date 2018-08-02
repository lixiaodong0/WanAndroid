package com.lixd.wanandroid.data;

import com.google.gson.annotations.SerializedName;

public class BaseData<T> {
    @SerializedName("errorMsg")
    public String errorMsg;
    @SerializedName("errorCode")
    public int errorCode;
    @SerializedName("data")
    public T data;
}
