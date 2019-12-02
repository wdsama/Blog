package top.wdsama.web;

import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 类名： 富文本编辑器 过滤器
 *
 * @Author wdsama
 * @Date 2019/12/1 16:00
 * @Version 1.0
 */
public class MyFilter extends StrutsPrepareAndExecuteFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        /*获取当前请求*/
        HttpServletRequest request = (HttpServletRequest) req;
        /*获取请求地址来判断*/
        String requestURI = request.getRequestURI();
        if (requestURI.contains("js/umedit/jsp/controller.jsp")){
            /*放行 使用原生过滤器*/
            chain.doFilter(req,res);
        }else {
            /*使用 struts2 的过滤器*/
            super.doFilter(req,res,chain);
        }
    }
}
