package com.java.website;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xdd
 * @date 2019/6/24
 */
@MapperScan(basePackages="com.java.website.*.mapper")
@SpringBootApplication
public class WebsiteApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebsiteApplication.class, args);
    }

}
