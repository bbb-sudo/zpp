package com.nbt.repair.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {

    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功！"),

    /**
     * 操作失败
     */
    ERROR(500, "操作失败！"),

    USERNAME_EXISTS(1001, "用户名已存在！");

    /**
     * 响应状态码
     */
    private final Integer code;

    /**
     * 响应提示信息
     */
    private final String message;
}