package com.cbf.data_exchange.read;

import com.cbf.data_exchange.config.DataExchangeConfig;
import com.cbf.data_exchange.config.DataType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
public class CSVFileReader extends BaseReader implements Reader{
    public CSVFileReader(BlockingQueue<Object> readyForIntermediateProcessQueue, int threadNumber, DataExchangeConfig config, AtomicReference<Boolean> isConsumeEnd) {
        super(readyForIntermediateProcessQueue, threadNumber, config, isConsumeEnd);
    }

    @Override
    public void read() {
        log.info("CSV file read stage start!");
        long timeCost = 0;
        DataType.FileType fileType = config.getReader().getFileReader();
        String filePath = fileType.getFileUrl();
        int headerLines = fileType.getFileHeaderLines();
        Map<Integer, String> indexAndColumnNameMap = null;
//        Path file = Paths.get(new File(filePath).toURI());
        Path file = Paths.get(filePath);
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(file)));
            indexAndColumnNameMap = processAndSkipHeader(reader, headerLines);
            String line = null;
            while((line = reader.readLine())!=null){
                /**
                 * 读取一行，key是columnName，value是columnValue
                 */
                 Map<String, String> readLineMap = new HashMap<>();
                 String[] columnList = line.split(",");
                 // 这里没有考虑某一行少了某一列或几列的情况（就算少了，也有有分隔符）
                 for(int i=0;i<columnList.length;i++){
                     String ColumnName = indexAndColumnNameMap.get(i);
                     readLineMap.put(ColumnName, columnList[i]);
                 }
                 readyForIntermediateProcessQueue.put(readLineMap);
            }
            /**
             * 将已read结束标志置为true
             */
            isReadEnd.set(true);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        log.info("CSV file read stage end!");
    }
    public Map<Integer, String> processAndSkipHeader(BufferedReader reader, int headerLines){
        String headerMapLine = "";
        for(int i=0;i<headerLines;i++){
            try{
                if(i==headerLines-1){
                    headerMapLine = reader.readLine();
                }else{
                    reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /**
         * 默认用逗号分割，以后可以配置separator
         */
        String[] columnList = headerMapLine.split(",");
        Map<Integer, String> map = new HashMap<>();
        for(int i=0;i<columnList.length;i++){
            map.put(i, StringUtils.trim(columnList[i]));
        }
        return map;
    }
}
