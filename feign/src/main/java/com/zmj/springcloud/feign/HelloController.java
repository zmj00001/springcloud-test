package com.zmj.springcloud.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 周美军
 * @Date: 2019/3/7 10:56
 * @Email: 536304123@QQ.COM
 */
@RestController
public class HelloController {

    @Autowired
    HelloInterface helloInterface;

    @RequestMapping(value = "/say",method = RequestMethod.GET)
    public String welcome(@RequestParam String name){
        return helloInterface.welcomeClientOne(name);
    }
}
