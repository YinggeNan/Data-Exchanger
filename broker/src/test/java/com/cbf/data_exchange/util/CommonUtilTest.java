package com.cbf.data_exchange.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/28
 * @description
 */
public class CommonUtilTest {
    @Test
    public void spliceWithStringsTest(){
        Assert.assertEquals("I am iron man",
                CommonUtil.spliceWithStrings("{} am {}", new String[]{"I", "iron man"}));
        Assert.assertEquals("{1} am { I",
                CommonUtil.spliceWithStrings("{1} am { {}", new String[]{"I", "iron man"}));
    }
    @Test
    public void loadEnvironmentTest(){
        String path = "D:\\workspace\\Data-Exchanger\\broker\\src\\main\\resources\\environment-test.properties";
        CommonUtil.loadEnvironment(path);
        Assert.assertEquals("cbf", System.getProperty("superStart"));
        Assert.assertEquals("shuai", System.getProperty("why"));
    }
}
