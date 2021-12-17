package com.zhongliang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.zhongliang.mapper")
@EnableEurekaClient
public class TableStateApplication {
    public static void main(String[] args) {
        SpringApplication.run(TableStateApplication.class,args);
    }
}
