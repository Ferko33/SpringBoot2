package com.ferko.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ferko.boot.mapper")
@SpringBootApplication
public class Boot03ThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot03ThymeleafApplication.class, args);
    }

}
