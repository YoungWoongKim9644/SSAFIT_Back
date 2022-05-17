package com.ssafy.ssafit.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.ssafit.interceptor.JWTInterceptor;

public class WebConfig implements WebMvcConfigurer{
	
	
	
	@Autowired
	private JWTInterceptor JWTInterceptor;
	
	@Override //어떤 url 경로에 interceptor를 매핑시킬지 설정
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(JWTInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/api/login");
	}
	
	

}
