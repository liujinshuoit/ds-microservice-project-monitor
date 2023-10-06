package com.das.consultation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: LJS
 * @Date: 2023/3/22 22:38
 */
@Configuration
public class MyWebAppConfiguration implements WebMvcConfigurer {

    //定制资源映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //意思是：url中读取到/upload时，就会自动将/upload解析成D:/idea/java_workspace/image/upload
        registry.addResourceHandler("/image/**").addResourceLocations("file:D:/microservice-project-monitor/image/");
        /**
         * Linux系统
         * registry.addResourceHandler("/upload/**").addResourceLocations("file:/home/image/upload/");
         */
    }
}