package com.hzit.demo.VO;

public class Resp<T> {
    private String code;
    private String msg;
    private T date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Resp{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                '}';
    }
}
