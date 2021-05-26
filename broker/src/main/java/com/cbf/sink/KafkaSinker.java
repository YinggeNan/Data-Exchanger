package com.cbf.sink;

import java.util.List;
import java.util.Map;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/26
 * @description
 */
public class KafkaSinker implements Sinker{
    @Override
    public int sink(List<Map<String, Object>> list) {
        return 0;
    }
}
