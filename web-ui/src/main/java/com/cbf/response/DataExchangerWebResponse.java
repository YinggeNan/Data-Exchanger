package com.cbf.response;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/6/2
 * @description
 */
public class DataExchangerWebResponse<T> {
    T data;
    int code;
    String msg;
    public DataExchangerWebResponse(T data){
        this.data = data;
        code = 200;
    }
}
