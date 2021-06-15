package com.bonc.cron.cronTest.result;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/5/25 10:25
 *
 * 错误信息
 */
public class CodeMessage {

    private int code;

    private String msg;

    // 通用异常
    public static CodeMessage SUCCESS = new CodeMessage(0,"success");
    public static CodeMessage SERVER_ERROR = new CodeMessage(500,"服务端异常！");


    public CodeMessage() {
    }

    private CodeMessage(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

