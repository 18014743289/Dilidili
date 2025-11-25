package com.he.dilidili;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.he.dilidili.mapper"})
@SpringBootApplication(scanBasePackages = "com.he.dilidili")
public class DilidiliApplication {

    public static void main(String[] args) {
        SpringApplication.run(DilidiliApplication.class, args);
    }

}
