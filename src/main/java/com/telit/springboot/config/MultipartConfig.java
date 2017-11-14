package com.telit.springboot.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.servlet.MultipartConfigElement;

//springboot默认使用tomcat的上传大小限制（1mb）
@Configuration
public class MultipartConfig {

    @Autowired
    private Environment environment;
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(environment.getProperty("multipart.maxFileSize"));
        factory.setMaxRequestSize(environment.getProperty("multipart.maxRequestSize"));
        return factory.createMultipartConfig();
    }
}
