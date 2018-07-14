package com.ief.storeproject.videoplay.vo;

public class ResponseVo {
    private String code;
    private String msg;
    private Object data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCode() {
        return code == null ? "00000" : code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
