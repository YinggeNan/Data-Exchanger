package com.cbf.data_exchange.util;

import com.cbf.data_exchange.config.DataExchangeConfig;
import org.junit.Test;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/28
 * @description
 */
public class FileParseUtilTest {
    @Test
    public void convertJSONAsObjectTest(){
        String jsonPath = "D:\\workspace\\Data-Exchanger\\broker\\src\\main\\resources\\TestLoadConfig.json";
        DataExchangeConfig config = FileParseUtil.convertJSONAsObject(DataExchangeConfig.class, jsonPath);
    }
}
