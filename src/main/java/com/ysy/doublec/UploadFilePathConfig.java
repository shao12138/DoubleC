package com.ysy.doublec;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class UploadFilePathConfig implements WebMvcConfigurer {
    @Value("${file.static-access-path}")
    private String staticAccessPath;
    @Value("${file.upload-folder}")
    private String uploadFolder;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 将本地磁盘的指定路径映射成Spring Boot的静态资源路径
        registry.addResourceHandler(staticAccessPath).addResourceLocations("file:" + uploadFolder);
    }
}