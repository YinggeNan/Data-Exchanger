package com.cbf;

import com.cbf.config.WebUiConfig;
import com.cbf.daos.MybatisConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Sky
 * @version 1.0
 * @date 2021/5/26
 * @description
 */
@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DataExchangerFrameWorkWeb{
    public static void main(String[] args) {
        SpringApplication.run(DataExchangerFrameWorkWeb.class, args);
        new MybatisConfig().test();
    }
}
