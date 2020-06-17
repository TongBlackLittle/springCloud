package com.illusion.spring.serviceapi.service.impl;

import com.illusion.spring.feignclient.UserCenterFeignClient;
import com.illusion.spring.serviceapi.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author littleblack TongTong
 * @create 2020-05-16 1:41 上午
 **/
@Service
//@DefaultProperties(defaultFallback = "defaultFallBack")
public class UserServiceImpl implements UserService {

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private UserCenterFeignClient userCenterFeignClient;

    private static String HYSTRIX = "hystrix";

    @Override
    //@HystrixCommand(fallbackMethod = "getHelloFallBack")
    //服务超时配置
    @HystrixCommand
    public String getHello(Integer test) {

        //RestTemplate restTemplate = new RestTemplate();
        //方式一
        //return restTemplate.getForObject("http://127.0.0.1:5621/hello", String.class);

        //方式二
        //ServiceInstance serviceInstance = loadBalancerClient.choose("USERCENTER");
        //String url = String.format("http://%s:%s/hello", serviceInstance.getHost(), serviceInstance.getPort());
        //return restTemplate.getForObject(url, String.class);
        //方式三
        /*if (test % 2 == 0) {
            return restTemplate.getForObject("http://usercenter/hello", String.class);
        } else {
            return "success";
        }*/


        // 集成 feinclient 方式进行调用
        return userCenterFeignClient.hello();
    }

    private String getHelloFallBack() {
        return "userCenter server down please wait~";
    }

    private String defaultFallBack() {
        return "default server down please wait~";
    }
}
