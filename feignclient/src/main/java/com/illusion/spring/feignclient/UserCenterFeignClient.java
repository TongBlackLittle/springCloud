package com.illusion.spring.feignclient;

import com.illusion.spring.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author littleblack
 */
@FeignClient(
        name = "USERCENTER",
        fallback = UserCenterFeignClient.UserCenterFeignClientFallBack.class,
        configuration = FeignClientConfig.class)
public interface UserCenterFeignClient {

    /**
     * 用户中心 hello 接口
     *
     * @return prompt
     */
    @GetMapping("/hello")
    String hello();

    @Component
    class UserCenterFeignClientFallBack implements UserCenterFeignClient {

        @Override
        public String hello() {
            return "usercenter hello is down wait a moment~";
        }
    }
}
