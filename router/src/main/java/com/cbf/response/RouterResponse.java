package com.cbf.response;

import lombok.Data;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/6/4
 * @description
 */
@Data
public class RouterResponse {
    int code;
    String msg;
    public RouterResponse(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public RouterResponse(int code){
        this. code = code;
    }
}
