package com.illusion.spring.usercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author littleblack
 */
@SpringCloudApplication
@ComponentScan(basePackages = "com.illusion")
@EnableFeignClients("com.illusion.spring")
@ComponentScan(basePackages = "com.illusion")
public class UsercenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsercenterApplication.class, args);
    }

}
