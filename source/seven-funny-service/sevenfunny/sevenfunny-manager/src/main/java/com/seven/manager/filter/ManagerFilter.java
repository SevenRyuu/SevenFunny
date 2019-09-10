package com.seven.manager.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：SevenRyuu
 * date   ：2019/9/10 12:03 PM
 * email  ：sevenryuu77@gmail.com
 * info   ：网关过滤器
 */
@Component
public class ManagerFilter extends ZuulFilter {

    //在请求前pre或者后执行post
    @Override
    public String filterType() {
        return "pre";
    }

    //多个过滤器的执行顺序、"0" 表示优先执行、越小越先执行
    @Override
    public int filterOrder() {
        return 0;
    }

    //当前过滤器是否开启、true表示开启
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //过滤器内执行的操作 return 任何object的值都表示继续执行
    //setSendZuulResponse(false)表示不再继续执行
    @Override
    public Object run() throws ZuulException {
        System.out.println("经过zuul过滤器了！！！");
        //得到Request上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //得到Request域
        HttpServletRequest request = currentContext.getRequest();

        //得到头信息
        String requestHeader = request.getHeader("Authorization");
        //判断是否有头信息
        if(StringUtils.isNotBlank(requestHeader)){
            //把头信息继续向下传
            currentContext.addZuulRequestHeader("Authorization", requestHeader);
        }
        return null;
    }
}
