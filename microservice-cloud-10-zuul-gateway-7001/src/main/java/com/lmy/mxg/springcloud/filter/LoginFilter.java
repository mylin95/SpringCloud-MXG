package com.lmy.mxg.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Package: com.lmy.mxg.springcloud.filter
 * @Description:
 * @Author: linmy
 * @Date: 2020/12/17
 */
@Component
public class LoginFilter extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(LoginFilter .class);

    /**
     * 返回值代表的含义：
     *
     * @return pre：在请求路由之前执行
     * route：在请求路由时调用
     * post：请求路由之后调用， 也就是在route和errror过滤器之后调用
     * error：处理请求发生错误时调用
     */
    @Override
    public String filterType() {
        // 因为是登录校验，需要在请求路由之前执行
        return "pre";
    }

    /**
     * 此方法返回整型数值，通过此数值来定义过滤器的执行顺序，数字越小优先级越高。
     *
     * @return 返回整型数值
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 返回Boolean值，判断该过滤器是否执行
     *
     * @return 返回true表示要执行此过虑器，false不执行。
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的业务逻辑。
     * demo：带有token参数的请求，表示已经登录过了，不进行拦截
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        if (token == null) {
            logger.info("此操作需要先登录系统...");
            // 拒绝访问
            context.setSendZuulResponse(false);
            // 设置响应码
            context.setResponseStatusCode(200);
            try {
                context.getResponse().getWriter().write("token is empty...");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        logger.info("用户已登录系统。");
        return null;
    }
}
