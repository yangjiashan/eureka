package com.yang.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@Component
public class DealRequestUrlFilter extends ZuulFilter {

    /**
     * 重定向的规则,根据key来重定向到val.
     */
    private static Map<String, String> urlMap = new HashMap<>();

    static {
        urlMap.put("t", "/test/");
    }

    @Override
    public String filterType() {
//        return FilterConstants.ROUTE_TYPE;
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
//        return 0;
        return FilterConstants.SEND_FORWARD_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(request.getRequestURL());
        System.out.println(request.getRequestURI());
//        String url = "http://193.100.100.18:807/newsignonwebservice/UserSignOn.asmx?wsdl";

        // 1.设置RouteHost
        URI uri = null;
        try {
            uri = new URI("http://193.100.100.18:807");
            System.out.println(uri.toURL());
            ctx.setRouteHost(uri.toURL());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // 2.将替换掉的url set进去,在对应的转发请求的url就会使用这个url
        ctx.put(FilterConstants.REQUEST_URI_KEY, "/newsignonwebservice/UserSignOn.asmx");

        return null;
    }
}
