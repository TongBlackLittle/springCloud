package com.illusion.spring.usercenter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author littleblack TongTong
 * @create 2020-05-16 9:56 下午
 **/
@Component
@Data
@ConfigurationProperties("config")
@RefreshScope
public class UserCenterConfigBean {
    private String prompt;
}
