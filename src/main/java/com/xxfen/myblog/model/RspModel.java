package com.xxfen.myblog.model;

public class RspModel<T> {
    private String msg;
    private int code;
    private T result;
    private static RspModel rspModel;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public RspModel() {
        this.code = 200;
        this.msg = "ok";
    }

    public RspModel(int code) {
        this.code = code;
        this.msg = "ok";
    }

    public RspModel(T result) {
        this();
        this.result = result;
    }

    public RspModel(String msg) {
        this.code = 200;
        this.msg = msg;
    }


    public void setResult(T result) {
        this.result = result;
    }

    public static <T> RspModel<T> bundleOk() {
        return new RspModel<>();
    }

    public static <T> RspModel<T> bundleOk(T result) {
        return new RspModel<>(result);
    }

    public static <T> RspModel<T> bundleError(int code) {
        return new RspModel<>(code);
    }

    public static <T> RspModel<T> bundleErrorNoData(int code) {
        return new RspModel<>(code);
    }
}
