package com.daisypig;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动主入口.
 * @author : chenwu
 */
@SpringBootApplication(scanBasePackages = {"com.daisypig", "com.daisypig.auth", "com.daisypig.common"})
public class ApplicationStarter {

    public static void main(String[] args) {
        System.setProperty("jasypt.encryptor.password","familyManage-secret");
        SpringApplication.run(ApplicationStarter.class, args);
    }


}
