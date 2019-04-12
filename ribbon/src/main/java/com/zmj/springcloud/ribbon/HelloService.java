package com.zmj.springcloud.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 周美军
 * @Date: 2019/3/7 10:44
 * @Email: 536304123@QQ.COM
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    public String helloService(String name) {
        return restTemplate.getForObject("http://HELLO/say?name="+name,String.class);
    }

    public String error(String name) {
        return "哎呀" + name + "出错了";
    }
}
