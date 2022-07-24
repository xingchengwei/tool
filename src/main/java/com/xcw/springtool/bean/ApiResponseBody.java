package com.xcw.springtool.bean;

import com.xcw.springtool.util.JsonObject;

import java.io.Serializable;

public class ApiResponseBody <T> implements Serializable {

    /**
     * 返回信息
     */
    private String message = "success";
    /**
     * 返回状态码
     */
    private int code = 200;
    /**
     * 返回对象
     */
    private T data;

    /**
     * 创建返回对象(空参数)
     */
    public ApiResponseBody() {
    }

    /**
     * 创建返回对象(全参数)
     *
     * @param code
     * @param message
     * @param data
     */
    public ApiResponseBody(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 创建返回对象
     *
     * @param code
     * @param message
     */
    public ApiResponseBody(int code, String message) {
        this(code, message, null);
    }

    /**
     * 创建返回对象
     *
     * @param data
     */
    public ApiResponseBody(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 根据状态码判断是否成功
     *
     * @return
     */
    public boolean isSuccess() {
        return DefaultConstants.SUCCESS_CODE.equals(this.code);
    }

    @Override
    public String toString() {
        return JsonObject.toJsonString(this);
    }

    /**
     * 创建成功的返回对象
     *
     * @param data
     * @param msg
     * @param <E>
     * @return
     */
    public static <E> ApiResponseBody<E> success(E data, String msg) {
        return new ApiResponseBody(DefaultConstants.SUCCESS_CODE, msg, data);
    }

    /**
     * 创建成功的返回对象
     *
     * @param data
     * @param <E>
     * @return
     */
    public static <E> ApiResponseBody<E> success(E data) {
        return new ApiResponseBody(DefaultConstants.SUCCESS_CODE, null, data);
    }

    /**
     *
     * @param data
     * @param msg
     * @param <E>
     * @return
     */
    public static <E> ApiResponseBody<E> checkFail(E data, String msg) {
        return new ApiResponseBody(200, msg, data);
    }

    /**
     *
     * @param data
     * @param <E>
     * @return
     */
    public static <E> ApiResponseBody<E> checkFail(E data) {
        return new ApiResponseBody(200, "checkFail", data);
    }

    /**
     * 创建失败的返回对象
     *
     * @param throwable
     * @param <E>
     * @return
     */
    public static <E> ApiResponseBody<E> fail(Throwable throwable) {
        return fail("-1", throwable != null ? throwable.getMessage() : "系统繁忙，请稍候再试");
    }

    /**
     * 创建失败的返回对象
     *
     * @param code
     * @param msg
     * @param <E>
     * @return
     */
    public static <E> ApiResponseBody<E> fail(int code, String msg) {
        return new ApiResponseBody(code, msg != null && !msg.isEmpty() ? msg : "系统繁忙，请稍候再试");
    }

    /**
     * 创建失败的返回对象
     *
     * @param msg
     * @param <E>
     * @return
     */
    public static <E> ApiResponseBody<E> fail(String msg) {
        return fail("-1", msg);
    }

    /**
     * 创建失败的返回对象
     *
     * @param msg
     * @param args
     * @param <E>
     * @return
     */
    public static <E> ApiResponseBody<E> fail(String msg, Object... args) {
        String message = msg != null && !msg.isEmpty() ? msg : "系统繁忙，请稍候再试";
        return new ApiResponseBody(-1, String.format(message, args));
    }
}
