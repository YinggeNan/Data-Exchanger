package com.cbf.sink;

import java.util.List;
import java.util.Map;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/26
 * @description:
 */
public interface Sinker {
    /**
     * 将一批数据sink到目标数据仓库（file、db、mq等）
     * 返回值是sink成功的数据条数
     * @param list
     * @return
     */
    int sink(List<Map<String, Object>> list);
}
