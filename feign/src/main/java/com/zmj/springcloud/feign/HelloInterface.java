package com.zmj.springcloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: 周美军
 * @Date: 2019/3/7 10:54
 * @Email: 536304123@QQ.COM
 */
@FeignClient(value = "welcome",fallback = HelloFailure.class)
public interface HelloInterface {

    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    String welcomeClientOne(@RequestParam(value = "name") String name);
}
