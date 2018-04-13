package com.yisutech.iisp.dataops;

import com.yisutech.iisp.toolkit.utils.SpringHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.yisutech.iisp.dataops.repository.mapper")
@ComponentScan("com.yisutech.iisp")
public class StarterApplication {

    @Resource
    private SpringHelper springHelper;

    public static void main(String[] args) {
        SpringApplication.run(StarterApplication.class, args);
    }
}
