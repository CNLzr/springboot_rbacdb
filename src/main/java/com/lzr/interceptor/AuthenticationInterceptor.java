package com.lzr.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 权限拦截器

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//         获取session
//        HttpSession session = request.getSession();
//        User user = (User)session.getAttribute("loginUser");
//        // 如果不为空，则表示用户已登录
//        if(user != null){
            return true;
//        }
//         如果为空，表示用户未登录，给用户重定向至登录页面
//        response.sendRedirect("/users/loginPage");
//        return false;
    }
}
