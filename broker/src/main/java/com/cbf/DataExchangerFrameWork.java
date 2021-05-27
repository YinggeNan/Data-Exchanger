package com.cbf;

import com.cbf.process.ThreeStageProcessor;
import com.cbf.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/26
 * @description
 */
@Slf4j
@SpringBootApplication
public class DataExchangerFrameWork implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(DataExchangerFrameWork.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        ThreeStageProcessor processor = CommonUtil.constructProcessor(null);
        processor.process();
    }
}
