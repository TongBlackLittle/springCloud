package com.illusion.spring.serviceapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author littleblack TongTong
 * @create 2020-05-14 4:02 下午
 **/
@Component
@Data
@ConfigurationProperties("config")
@RefreshScope
public class ConfigBean {
    private Integer commentLength;
    private String prompt;
}
