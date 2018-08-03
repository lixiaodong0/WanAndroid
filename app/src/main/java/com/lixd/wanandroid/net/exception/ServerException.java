package com.lixd.wanandroid.net.exception;

public class ServerException extends Exception {

    public int errorCode;
    public String errorMsg;

    public ServerException(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
