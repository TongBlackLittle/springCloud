package com.illusion.spring.feignclient;

import com.illusion.spring.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author littleblack
 */
@FeignClient(
        name = "SERVICE-API",
        fallback = ServiceApiFeignClient.ServiceApiFeignClientFallBack.class,
        configuration = FeignClientConfig.class)
public interface ServiceApiFeignClient {

    /**
     * @return hello
     */
    @GetMapping("/hello")
    String hello();

    @Component
    class ServiceApiFeignClientFallBack implements ServiceApiFeignClient {

        @Override
        public String hello() {
            return "service-api hello is down wait a moment~";
        }
    }
}
