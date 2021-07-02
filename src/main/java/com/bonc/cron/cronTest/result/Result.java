package com.bonc.cron.cronTest.result;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/5/25 10:14
 * <p>
 * 响应的返回信息
 */
public class Result<T> {

    /**
     * 状态码
     */
    private int code;

    /**
     * 信息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    public Result() {
    }

    public Result(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }


    public Result(CodeMessage codeMessage) {
        if (null == codeMessage) {
            return;
        }
        this.code = codeMessage.getCode();
        this.msg = codeMessage.getMsg();
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }


    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    public static <T> Result<T> fail(CodeMessage codeMessage) {
        return new Result<T>(codeMessage);
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
