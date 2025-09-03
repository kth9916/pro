package com.asan.pro.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.asan.pro") // 모든 pro 하위 패키지 스캔
public class ProBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProBootApplication.class, args);
    }

}
