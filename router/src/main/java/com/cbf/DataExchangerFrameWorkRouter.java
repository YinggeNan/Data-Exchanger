package com.cbf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/26
 * @description
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DataExchangerFrameWorkRouter {
    public static void main(String[] args) {
        SpringApplication.run(com.cbf.DataExchangerFrameWorkRouter.class, args);
    }
}
