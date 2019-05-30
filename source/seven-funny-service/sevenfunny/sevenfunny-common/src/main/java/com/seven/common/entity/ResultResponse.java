package com.seven.common.entity;

import java.io.Serializable;

/**
 * @author ：SevenRyuu
 * date   ：2019/5/30 8:30 PM
 * email  ：sevenryuu77@gmail.com
 */
public class ResultResponse implements Serializable {

    private Integer code;

    private String message;

    private Object data;

    public ResultResponse(ResultCode resultCode, Object data) {
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
