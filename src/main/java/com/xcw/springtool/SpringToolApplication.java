package com.xcw.springtool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.xcw.springtool.dao")
public class SpringToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringToolApplication.class, args);
    }

}
