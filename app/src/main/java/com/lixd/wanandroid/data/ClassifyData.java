package com.lixd.wanandroid.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClassifyData {
    /*
    "children": [],
    "courseId": 13,
    "id": 294,
    "name": "完整项目",
    "order": 145000,
    "parentChapterId": 293,
    "visible": 0
    * */
    @SerializedName("children")
    public List<Object> children;
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

    //是否选中的
    public boolean isSelected;
}
