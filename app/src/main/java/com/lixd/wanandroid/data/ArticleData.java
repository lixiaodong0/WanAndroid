package com.lixd.wanandroid.data;

import java.util.List;

public class ArticleData {

    /**
     * "apkLink": "",
     * "author": "lovejjfg",
     * "chapterId": 294,
     * "chapterName": "完整项目",
     * "collect": false,
     * "courseId": 13,
     * "desc": "Readhub Android 客户端，当然是非官方的，不能说是最早做的，但是说到 Kotlin 语言编写，那么应该算最早的啦。项目 2.3M 左右，目前正在持续更新中，GooglePlay 小米应用市场均可下载。Readhub 实验室有收录，欢迎点赞。https://github.com/lovejjfg/Readhub/blob/master/README.md",
     * "envelopePic": "http://www.wanandroid.com/blogimgs/0ce4709e-9b54-4eea-9337-9f33823f0b81.png",
     * "fresh": false,
     * "id": 3216,
     * "link": "http://www.wanandroid.com/blog/show/2262",
     * "niceDate": "2018-08-03",
     * "origin": "",
     * "projectLink": "https://github.com/lovejjfg/Readhub",
     * "publishTime": 1533226271000,
     * "superChapterId": 294,
     * "superChapterName": "开源项目主Tab",
     * "tags": [
     * {
     * "name": "项目",
     * "url": "/project/list/1?cid=294"
     * }
     * ],
     * "title": "Readhub 客户端",
     * "type": 0,
     * "userId": -1,
     * "visible": 1,
     * "zan": 0
     */
    public String apkLink;
    public String author;
    public int chapterId;
    public String chapterName;
    public boolean collect;
    public int courseId;
    public String desc;
    public String envelopePic;
    public boolean fresh;
    public int id;
    public String link;
    public String niceDate;
    public String origin;
    public String projectLink;
    public String publishTime;
    public int superChapterId;
    public String superChapterName;
    public List<Tag> tags;
    public String title;
    public int type;
    public int userId;
    public int visible;
    public int zan;

    public static class Tag {
        public String name;
        public String url;
    }
}
