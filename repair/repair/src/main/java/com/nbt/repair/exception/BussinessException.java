package com.nbt.repair.exception;

import com.nbt.repair.response.ResponseCode;
import lombok.Data;

@Data
public class BussinessException extends RuntimeException{
    /**
     * 错误码
     */
    private Integer code;
    private String message;

    public BussinessException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
    public BussinessException(String message) {
        this.message = message;
    }
    public BussinessException(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }
}
