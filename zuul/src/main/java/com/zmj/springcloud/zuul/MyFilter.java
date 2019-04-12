package com.zmj.springcloud.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 周美军
 * @Date: 2019/3/7 12:38
 * @Email: 536304123@QQ.COM
 */
@Component
public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        Object accesstoken = request.getParameter("token");
        if(accesstoken == null) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);

            try {
                context.getResponse().setHeader("Content-Type","text/html;charset=UTF-8");
                context.setResponseBody(new ResultVO(10040,"登录信息不正确").toString());

            }catch (Exception e) {
               // e.printStackTrace();
            }
            return null;
        }
        return null;
    }
}
