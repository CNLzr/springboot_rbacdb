package com.lzr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.lzr.dao")
public class RBACApplication {
    public static void main(String[] args) {
        SpringApplication.run(RBACApplication.class,args);
    }
}
