package com.yang.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AccessFilter extends ZuulFilter {
    private final Logger LOGGER = LogManager.getLogger();

    @Override
    public String filterType() {
        // 过滤器在哪个生命周期中执行，pre表示请求被路由之前
        return "pre";
    }

    @Override
    public int filterOrder() {
        // 过滤器执行顺序，单多个过滤器时设置顺序值
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 过滤器是否被执行，可以运用该函数控制过滤的有效范围
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
//        try {
            // 过滤具体逻辑
            RequestContext requestContext = RequestContext.getCurrentContext();
            HttpServletRequest request = requestContext.getRequest();
            Object accessToken = request.getParameter("accessToken");
//        if (accessToken == null) {
//            // 不进行路由
//            requestContext.setSendZuulResponse(false);
//            requestContext.setResponseStatusCode(401);
//            return null;
//        }
            // 获取服务列表
            LOGGER.info("进入过滤器！！！");

//            int i = 1/0;


//        } catch (Exception e) {
//            ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            ctx.set("error.exception", e);
//        }
//        ctx.addZuulResponseHeader("");


        return null;
    }
}
