package com.zmj.springcloud.feign;

import org.springframework.stereotype.Component;

/**
 * @Author: 周美军
 * @Date: 2019/3/7 11:31
 * @Email: 536304123@QQ.COM
 */
@Component
public class HelloFailure implements HelloInterface {

    @Override
    public String welcomeClientOne(String name) {
        return "哎呀呀,不好意思" + name + ",出错了呀!";
    }
}
