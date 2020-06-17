package com.illusion.spring.usercenter.controller;

import com.illusion.spring.feignclient.ServiceApiFeignClient;
import com.illusion.spring.usercenter.config.UserCenterConfigBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author littleblack TongTong
 * @create 2020-05-16 9:55 下午
 **/
@RestController
public class TestController {

    @Resource
    private UserCenterConfigBean userCenterConfigBean;

    @Resource
    private ServiceApiFeignClient serviceApiFeignClient;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() throws InterruptedException {
        Thread.sleep(4000);
        return serviceApiFeignClient.hello();
    }
}
