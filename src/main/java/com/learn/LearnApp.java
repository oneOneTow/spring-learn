package com.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: luzhiqing
 * @date: 2021-02-06
 **/
@SpringBootApplication(scanBasePackages = "com.learn")
@EnableAsync
@EnableTransactionManagement
public class LearnApp {
    public static void main(String[] args) {
//        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/luzhiqing/work/java/learn/spring-learn/src/main/resources");
        SpringApplication.run(LearnApp.class, args);
    }
}
