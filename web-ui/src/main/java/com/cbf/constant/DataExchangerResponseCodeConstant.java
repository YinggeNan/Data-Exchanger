package com.cbf.constant;

import javafx.util.Pair;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/6/2
 * @description:
 * Http code table:http://tools.jb51.net/table/http_status_code
 */
public class DataExchangerResponseCodeConstant {
    public static class Common{
        public static final int ok = 200;
        public static final int created = 201;
        public static final int BAD_REQUEST = 400;
        public static final int UNAUTHORIZED = 401;
        public static final int INTERNAL_SERVER_ERROR = 500;
    }

    /**
     * 1001~2000
     */
    public static class Task{
        public static final Pair<Integer, String> TASK_CONTENT_ERROR = new Pair<>(1001, "task name can't be null");
    }
    /**
     * 2001~3000
     */
    public static class User{

    }
}
