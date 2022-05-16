package com.lzr.util;

public final class APIResult<T> {
    private Integer code;
    private String message;
    private T data;

    private final static Integer CODE_OK = 2000;
    private final static Integer CODE_KO = 4000;
    private final static String SUCCESS_MSG = "成功";
    private final static String ERROR_MSG = "失败";

    private APIResult(){
    }

    private APIResult(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public static APIResult success(){
        return new APIResult<>(CODE_OK,SUCCESS_MSG);
    }

    public static <T> APIResult<T> success(T data){
        APIResult apiResult = success();
        apiResult.setData(data);
        return apiResult;
    }

    public static APIResult error(){
        return new APIResult(CODE_KO,ERROR_MSG);
    }

    public static <T> APIResult<T> error(T data){
        APIResult apiResult = error();
        apiResult.setData(data);
        return apiResult;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
