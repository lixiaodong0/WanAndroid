package com.lixd.wanandroid.net.okhttp;


import com.lixd.wanandroid.util.JsonUtil;
import com.lixd.wanandroid.util.LogUtil;

import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpLog implements HttpLoggingInterceptor.Logger {

    private StringBuilder builder = new StringBuilder();

    @Override
    public void log(String msg) {
        // 请求或者响应开始
        if (msg.startsWith("--> POST")) {
            builder.setLength(0);
        }
        // 以{}或者[]形式的说明是响应结果的json数据，需要进行格式化
        if ((msg.startsWith("{") && msg.endsWith("}"))
                || (msg.startsWith("[") && msg.endsWith("]"))) {
            msg = JsonUtil.formatJson(JsonUtil.decodeUnicode(msg));
        }
        builder.append(msg.concat("\n"));
        // 响应结束，打印整条日志
        if (msg.startsWith("<-- END HTTP")) {
            LogUtil.d(builder.toString());
        }
    }
}
