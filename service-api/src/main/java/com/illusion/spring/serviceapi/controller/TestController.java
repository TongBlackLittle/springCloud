package com.illusion.spring.serviceapi.controller;

import com.illusion.spring.serviceapi.config.ConfigBean;
import com.illusion.spring.serviceapi.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author littleblack TongTong
 * @create 2020-05-14 5:24 下午
 **/
@RestController
public class TestController {
    @Resource
    private ConfigBean configBean;

    @Resource
    private UserService userService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return configBean.getPrompt();
    }

    @RequestMapping(value = "/get_usercenter_hello", method = RequestMethod.GET)
    public String getUserCenterHello(@RequestParam Integer test) {
        return userService.getHello(test);
    }
}
