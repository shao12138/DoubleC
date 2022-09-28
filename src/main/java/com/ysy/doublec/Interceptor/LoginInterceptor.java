package com.ysy.doublec.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//实现HandlerInterceptor接口实现拦截器
public class LoginInterceptor implements HandlerInterceptor {
    // 定义该拦截器直接放行的请求：/login
    private static final String[] IGNORE_URIS = {"/login.html", "/login", "/logout.html",};

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求的路径进行判断
        String servletPath = request.getServletPath();
        // 判断请求是否需要拦截
        for (String s : IGNORE_URIS) {
            if (servletPath.contains(s)) {
                // 如果请求不需要拦截，直接“放行”请求
                return true;
            }
        }
        // 获取session中的user属性
        String username = (String) request.getSession().getAttribute("username");
        // 要求用户必须以特定用户名登录
        if (username == null) {
            // 如果用户没有登录，则设置提示信息，跳转到登录页面
            request.setAttribute("tip", "您还未登陆！");
            response.sendRedirect("/login.html");
            // 返回false，不再执行后续处理
            return false;
        } else {
            // 如果用户已经登录，则验证通过，“放行”请求
            return true;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
    }
}