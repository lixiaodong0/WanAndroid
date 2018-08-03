package com.lixd.wanandroid.util;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * 参考:https://www.jianshu.com/p/e044cab4f530
 */
public class LogUtil {

    /**
     * 初始化日志工具
     *
     * @param isOutputLog 是否输出日志
     */
    public static final void init(boolean isOutputLog) {
        Logger.init()
                .hideThreadInfo()
                .logLevel(isOutputLog ? LogLevel.FULL : LogLevel.NONE)
                .methodOffset(2);
    }

    public static final void i(String msg) {
        Logger.i(msg);
    }

    public static final void d(String msg) {
        Logger.d(msg);
    }

    public static final void e(String msg) {
        Logger.e(msg);
    }

    public static final void json(String msg) {
        Logger.json(msg);
    }

    private static StringBuilder builder = new StringBuilder();

    public static final void http(String msg) {
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
            d(builder.toString());
        }
    }
}
