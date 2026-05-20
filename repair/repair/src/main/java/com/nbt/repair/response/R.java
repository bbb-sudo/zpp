package com.nbt.repair.response;

import com.nbt.repair.response.ResponseCode;
import lombok.Getter;

/**
 * 统一响应结果封装类
 * @param <T> 响应数据类型
 */
@Getter
public class R<T> {

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 提示信息
     */
    private final String message;

    /**
     * 泛型类型的数据，自定义类型
     */
    private final T data;

    /**
     * 单参构造
     */
    private R(Integer code) {
        this(code, null, null);
    }

    /**
     * 双参构造
     */
    private R(Integer code, String message) {
        this(code, message, null);
    }

    /**
     * 三参构造
     */
    private R(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // ------------------- 成功响应 -------------------
    public static <T> R<T> success() {
        return new R<>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> R<T> success(String message) {
        return new R<>(ResponseCode.SUCCESS.getCode(), message);
    }

    public static <T> R<T> data(T data) {
        return new R<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), data);
    }

    // ------------------- 失败响应 -------------------
    public static <T> R<T> fail() {
        return new R<>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getMessage());
    }

    public static <T> R<T> fail(String message) {
        return new R<>(ResponseCode.ERROR.getCode(), message);
    }

    public static <T> R<T> fail(ResponseCode responseCode) {
        return new R<>(responseCode.getCode(), responseCode.getMessage());
    }

    public static <T> R<T> fail(Integer code, String message) {
        return new R<>(code, message);
    }
}