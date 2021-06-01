package com.cbf;

import com.cbf.data_exchange.config.DataExchangeConfig;
import com.cbf.data_exchange.process.ThreeStageProcessor;
import com.cbf.data_exchange.util.FileParseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/26
 * @description
 */
@Slf4j
@SpringBootApplication
public class DataExchangerFrameWorkBroker implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(DataExchangerFrameWorkBroker.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        String configPath = System.getProperty("CONFIG_LOCATION");
        if(configPath==null){
            configPath = "D:\\workspace\\Data-Exchanger\\broker\\src\\main\\resources\\TestLoadConfig.json";
        }
        DataExchangeConfig config = FileParseUtil.convertJSONAsObject(DataExchangeConfig.class, configPath);
        new ThreeStageProcessor().process(config);
    }
}
