package com.ferko.boot.config;

import com.ferko.boot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")// /** 代表所有请求都会被拦截，包括静态资源。
                .excludePathPatterns("/", "/login","/css/**","/fonts/**","/images/**","/js/**");
    }
}
