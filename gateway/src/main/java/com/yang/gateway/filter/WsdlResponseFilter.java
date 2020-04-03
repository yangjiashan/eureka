package com.yang.gateway.filter;

import com.google.common.net.HttpHeaders;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.w3c.dom.Document;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import static com.netflix.zuul.context.RequestContext.getCurrentContext;
import static org.springframework.util.ReflectionUtils.rethrowRuntimeException;

@Component
public class WsdlResponseFilter extends ZuulFilter {

    private transient final String wsdlUrl = "/ConvergenceCityCatalog/ws/";

    @Override
    public boolean shouldFilter() {
        return false;
//        RequestContext context = getCurrentContext();
//        String url = context.getRequest().getRequestURI();
//        String queryStr = context.getRequest().getQueryString();
//        return url.contains(wsdlUrl) && queryStr != null && queryStr.endsWith("wsdl");
    }

    @Override
    public Object run() {
        RequestContext context = getCurrentContext();
        // 编码格式
//        String charset = context.getRequest().getCharacterEncoding();
//        InputStream streamTemp = context.getResponseDataStream();
//        InputStream stream = context.getResponseDataStream();
//        context.getResponse().addHeader("Content-Encoding", "gzip");


//        context.addZuulResponseHeader("Content-Encoding", "gzip");
//        context.addZuulResponseHeader("Content-Type", "text/xml;charset=UTF-8");


        return null;
    }

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 2;
    }

}
