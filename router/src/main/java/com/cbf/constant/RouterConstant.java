package com.cbf.constant;

import javafx.util.Pair;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/6/4
 * @description
 */
public class RouterConstant {
    public static class Response{
        public static final Pair<Integer, String> OK = new Pair<>(200, "execute success");
        public static final Pair<Integer, String> FAILED = new Pair<>(500, "execute failed");
    }
}
