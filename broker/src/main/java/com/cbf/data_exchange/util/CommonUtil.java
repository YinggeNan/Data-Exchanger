package com.cbf.data_exchange.util;

import com.cbf.data_exchange.config.DataExchangeConfig;
import com.cbf.data_exchange.process.ThreeStageProcessor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/27
 * @description
 */
public class CommonUtil {
    /**
     * 将数据库里的配置反序列化为config对象
     * @return
     */
    public static DataExchangeConfig deseriaze(){
        return null;
    }
    public static ThreeStageProcessor constructProcessor(DataExchangeConfig config){
        return null;
    }

    /**
     * input:("{} am {}", ["I", "iron man"])
     * output: I am iron man
     * intput:("{1} am { {}",["I", "iron man"]
     * output: {1} am { I
     * @param source
     * @param adds
     * @return
     */
    public static String spliceWithStrings(String source, String[] adds){
        int addsIndex = 0;
        StringBuilder res = new StringBuilder();
        for(int i=0;i<source.length();i++){
            if(source.charAt(i)=='{' && i+1<source.length() &&
                    source.charAt(i+1)=='}' && addsIndex<adds.length){
                res.append(adds[addsIndex]);
                addsIndex++;
                i ++;
            }else{
                res.append(source.charAt(i));
            }
        }
        return res.toString();
    }
    public static void loadEnvironment(String configLocation){
        Properties properties = new Properties();
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(configLocation));
            properties.load(bufferedReader);
            for(String key:properties.stringPropertyNames()){
                System.setProperty(key, properties.getProperty(key));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
