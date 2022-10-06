package com.ysy.doublec.Interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //一定要加上这个注解，成为Springboot的配置类，不然不会生效
public class InterceptorConfig implements WebMvcConfigurer {
    @Override   //拦截器配置
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).excludePathPatterns("/css/**","/fonts/**","/js/**","/images/**","/lib/**","/assembly/**");
    }
}
