package com.zmj.springcloud.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 周美军
 * @Date: 2019/3/7 10:46
 * @Email: 536304123@QQ.COM
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;
    @RequestMapping(value = "/say")
    public String hello(@RequestParam String name){
        return helloService.helloService(name);
    }
}
