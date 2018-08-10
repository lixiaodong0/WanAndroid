package com.lixd.wanandroid.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TreeData {
    /**
     * children[]
     * "courseId": 13,
     * "id": 150,
     * "name": "开发环境",
     * "order": 1,
     * "parentChapterId": 0,
     * "visible": 1
     */
    @SerializedName("children")
    public List<TreeData> children;
    @SerializedName("courseId")
    public int courseId;
    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("order")
    public int order;
    @SerializedName("parentChapterId")
    public int parentChapterId;
    @SerializedName("visible")
    public int visible;
}
