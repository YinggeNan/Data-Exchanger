package com.cbf.data_exchange.util;



import com.google.gson.Gson;

import java.io.*;
import java.util.Map;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/28
 * @description
 */
public class FileParseUtil {
    private static Gson gson = new Gson();
    public static <T> T convertJSONAsObject(Class<T> clazz, String jsonPath){
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(jsonPath))));
            StringBuffer sb = new StringBuffer();
            String temp = "";
            while((temp = bufferedReader.readLine())!=null){
                sb.append(temp);
            }
            String str = sb.toString();
            return gson.fromJson(sb.toString(), clazz);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static <T> T convertYAMLAsObject(Class<T> clazz, String yamlPath){
        return null;
    }
    public Map<String, String>  convertPropertyAsMap(String propertyPath){
        return null;
    }
}
