package com.zmj.springcloud.zuul;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.io.Serializable;

/**
 * @Author: 周美军
 * @Date: 2019/3/7 12:59
 * @Email: 536304123@QQ.COM
 */
public class ResultVO implements Serializable {

    private static final long serialVersionUID = 847049800837078164L;

    public int code;

    public String msg;

    public Object data;

    public ResultVO() {
    }

    public ResultVO(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

}
