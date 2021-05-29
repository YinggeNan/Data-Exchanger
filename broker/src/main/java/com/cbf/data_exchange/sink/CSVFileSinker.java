package com.cbf.data_exchange.sink;

import com.cbf.data_exchange.config.DataExchangeConfig;
import com.cbf.data_exchange.config.DataType;
import com.cbf.data_exchange.read.BaseReader;
import com.cbf.data_exchange.read.Reader;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
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
public class CSVFileSinker extends BaseSinker implements Sinker {


    public CSVFileSinker(BlockingQueue<Object[]> readyForSinkQueue, int threadNumber, DataExchangeConfig config, AtomicReference<Boolean> isIntermediateProcessEnd) {
        super(readyForSinkQueue, threadNumber, config, isIntermediateProcessEnd);
    }

    @Override
    public void sink() {
        DataType.FileType fileType = config.getSinker().getFileSinker();
        String filePath = fileType.getFileUrl();
        int headerLines = fileType.getFileHeaderLines();
        Map<Integer, String> indexAndColumnNameMap = null;
        Path file = Paths.get(filePath);
        try{
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(file)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeHeader(BufferedWriter writer, String[] headerLines){

    }
}
