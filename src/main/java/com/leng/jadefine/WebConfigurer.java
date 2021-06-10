package com.leng.jadefine;

//import com.leng.jadefine.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * FileName:WebConfigurer
 * Author:fall
 * Date:2021/6/9 14:23
 * Description:
 */

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
/*
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());

       *//* 拦截所有请求*//*
        registration.addPathPatterns("/**");

        *//*排除静态资源*//*
        registration.excludePathPatterns("/system/*","/css/*","/js/*","/jquery-easyui-1.7.0/**","/image/*");

        *//*排除指定请求*//*
        registration.excludePathPatterns("/","login","logout","system/*");*/
    }
}
