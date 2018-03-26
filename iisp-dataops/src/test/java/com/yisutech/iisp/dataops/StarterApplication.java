package com.yisutech.iisp.dataops;

import com.yisutech.iisp.toolkit.utils.SpringHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;

@SpringBootApplication
@MapperScan("com.yisutech.iisp.dataops.repository.mapper")
@ComponentScan("com.yisutech.iisp")
public class StarterApplication {

    @Resource
    private SpringHelper springHelper;

    public static void main(String[] args) {
        SpringApplication.run(StarterApplication.class, args);
    }
}
