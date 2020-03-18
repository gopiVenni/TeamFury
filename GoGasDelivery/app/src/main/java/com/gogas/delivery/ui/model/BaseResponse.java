package com.gogas.delivery.ui.model;

import com.google.gson.annotations.SerializedName;

public class BaseResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("msg")
    private String msg;

    @SerializedName("flag")
    private boolean flag;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
