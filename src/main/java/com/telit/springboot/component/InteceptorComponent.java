package com.telit.springboot.component;

import com.telit.springboot.interceptor.HandlerInteceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 拦截器
 */
@Configuration
public class InteceptorComponent extends WebMvcConfigurerAdapter {

    public void addInterceptors(InterceptorRegistry registry) {
    	InterceptorRegistration iRegistry=registry.addInterceptor(new HandlerInteceptor());
    	/**
    	 * 设置拦截的url
    	 */
    	iRegistry.addPathPatterns("/**");
    	
    	/**
    	 * 设置不拦截的url
    	 */
    	iRegistry.excludePathPatterns("/login");
		iRegistry.excludePathPatterns("/noAuth");
    	iRegistry.excludePathPatterns("/app/**");
    }
}
