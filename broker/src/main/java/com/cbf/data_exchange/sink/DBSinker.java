package com.cbf.data_exchange.sink;

import com.cbf.data_exchange.config.DataExchangeConfig;
import com.cbf.data_exchange.config.DataType;
import com.cbf.data_exchange.dao.GenericDAO;
import com.cbf.data_exchange.util.DBUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/26
 * @description
 */
@Slf4j
public class DBSinker extends BaseSinker implements Sinker{
    public DBSinker(BlockingQueue<Object> readyForSinkQueue, int threadNumber,
                    DataExchangeConfig config, AtomicReference<Boolean> isIntermediateProcessEnd) {
        super(readyForSinkQueue, threadNumber, config, isIntermediateProcessEnd);
    }

    @Override
    public void sink() {
        log.info("db sink stage start!");
        GenericDAO genericDAO = constructDao();
        String insertSql = "INSERT INTO sink_test_dataexchanger (cobdate,country,province,city,carNumber,profit) VALUES (?,?,?,?,?,?) ";
        int batchSinkNumber = config.getSinker().getDbSinker().getBatchSinkNumber();
        long startTime = System.currentTimeMillis();
        Runnable sinkTask = () -> {
            while(!isIntermediateProcessEnd.get() || readyForSinkQueue.size()>0){
                List<Object[]> batchData = new LinkedList<>();
                int currentBatch = readyForSinkQueue.drainTo(Collections.singleton(batchData), batchSinkNumber);
                genericDAO.simpleBatchUpdate(insertSql, batchData);
            }
        };
        for(int i=0;i<threadNumber;i++){
            sinkExecutorService.execute(sinkTask);
        }
        try{
            sinkExecutorService.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        log.info("db sink stage end!");
        log.info("db sink stage cost:{}ms", endTime-startTime);
    }
    public GenericDAO constructDao(){
        DataType.DBType dbType = config.getSinker().getDbSinker();
        JdbcTemplate jdbcTemplate = DBUtil.getJdbcTemplateBuilder().
                setPs(dbType.getPassword()).
                setUrl(dbType.getUrl()).
                setDriverClass(dbType.getDriverClass()).
                setUserName(dbType.getUserName()).
                buildJdbcTemplate();
        return new GenericDAO(jdbcTemplate);
    }
}
