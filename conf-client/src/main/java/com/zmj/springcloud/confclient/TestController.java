package com.zmj.springcloud.confclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 周美军
 * @Date: 2019/3/8 9:21
 * @Email: 536304123@QQ.COM
 */
@RestController
@RequestMapping("/test")
@RefreshScope
public class TestController {

    @Value("${username}")
    String username;
    @Value("${password}")
    String password;


    @RequestMapping(value = "/user")
    public String user(){
        return "您好，您用户名为："+username+",密码为："+password;
    }
}
