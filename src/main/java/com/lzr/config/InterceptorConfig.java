package com.lzr.config;

import com.lzr.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns拦截的路径
        String[] addPathPatterns = {
                "/**"
        };

        //excludePathPatterns排除的路径
        String[] excludePathPatterns = {
                "/",
                "/css/**",
                "/js/**",
                "/html/**",
                "/views/**",
                "/users/loginPage",
                "/users/login"
        };
        registry.addInterceptor(new AuthenticationInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }
}
