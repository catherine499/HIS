package com.example.HIS.config;

import com.example.HIS.Interceptor.RemeberLoginIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private RemeberLoginIntercepter remeberLoginIntercepter;

    /*添加登录拦截器*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(remeberLoginIntercepter)
                .addPathPatterns("/**")
                .excludePathPatterns("/index2.html","/index","/","/login","/register.html","/staff-login.html","/staff_login","/register",
                        "/css/**","/fonts/**","/img/**",
                        "/js/**","/login.html","/style.css");
    }
}
