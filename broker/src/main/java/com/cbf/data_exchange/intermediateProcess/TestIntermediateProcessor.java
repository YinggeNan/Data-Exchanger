package com.cbf.data_exchange.intermediateProcess;

import com.cbf.data_exchange.config.DataExchangeConfig;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/27
 * @description
 */
@Slf4j
public class TestIntermediateProcessor extends BaseIntermediatProcessor implements  IntermediateProcessor{


    public TestIntermediateProcessor(BlockingQueue<Object> readyForIntermediateProcessQueue, BlockingQueue<Object> readyForSinkQueue, Integer threadNumber, DataExchangeConfig config, AtomicReference<Boolean> isConsumeEnd, AtomicReference<Boolean> isIntermediateProcessEnd) {
        super(readyForIntermediateProcessQueue, readyForSinkQueue, threadNumber, config, isConsumeEnd, isIntermediateProcessEnd);
    }

    @Override
    public void intermediateProcess() {
        log.info("test intermediateProcess stage start!");
        String insertSql = "INSERT INTO sink_test_dataexchanger (cobdate,country,province,city,carNumber,profit) VALUES (?,?,?,?,?,?) ";
        String[] sinkSequence = new String[]{"cobdate", "country", "province", "city", "carNumber", "profit"};
        String mapFilePath = config.getColumnMapFilePath();
        int timeCost = 0;
        /**
         * {readColumnName:sinkColumnName}
         */
        Map<String, String> sinkColumnAndReadColumnMap = constructSinkColumnAndReadColumnMap(mapFilePath);
        while(!isReadEnd.get() || readyForIntermediateProcessQueue.size()>0){
            if(readyForIntermediateProcessQueue.size()>0){
                long actualStartTime = System.currentTimeMillis();
                /**
                 * {readColumnName:readColumnValue}
                 * 先默认为是file read，后面再改为通用的
                 */
                Map<String, String> readColumnNameAndValueMap = (Map<String, String>)readyForIntermediateProcessQueue.poll();
                //这里没有什么诸如日期格式改变，一行便多行，或者列聚合等操作，所有直接略过
                //先构造为object[]格式，测试整个流程
                Object[] objects = new Object[sinkSequence.length];
                for(int i=0;i<sinkSequence.length;i++){
                    String readColumnName = sinkColumnAndReadColumnMap.get(sinkSequence[i]);
                    objects[i] = readColumnNameAndValueMap.get(readColumnName);
                }
                long actualEndTime = System.currentTimeMillis();
                timeCost += actualEndTime - actualStartTime;
                try{
                    readyForSinkQueue.put(objects);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        /**
         * 将intermediateProcess标志置为true
         */
        isIntermediateProcessEnd.set(true);
        log.info("test intermediateProcess stage end!");
        log.info("test intermediateProcess stage time cost {}ms",timeCost);
    }


    public Map<String, String> constructSinkColumnAndReadColumnMap(String mapFilePath){
        Gson gson = new Gson();
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(mapFilePath))));
            StringBuffer sb = new StringBuffer();
            String temp = "";
            while((temp = bufferedReader.readLine())!=null){
                sb.append(temp);
            }
            return gson.fromJson(sb.toString(), Map.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
