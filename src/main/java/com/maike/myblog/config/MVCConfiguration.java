package com.maike.myblog.config;

import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.maike.myblog.interceptor.LoginInterceptor;

/**
 * @projectname BeautyClothes
 * @author GEEKCJJ
 * @date 2019年8月13日 上午11:18:36
 * @description:
 *
 */
@Component
public class MVCConfiguration implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/login").excludePathPatterns("/static/**");
	}

	/**
	 * 拦截器
	 */
//	public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/emp/toLogin","/emp/login","/js/**","/css/**","/images/**");
//    }
	/**
	 * 添加类型转换器和格式化器
	 * 
	 * @param registry
	 */
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatterForFieldType(LocalDate.class, new USLocalDateFormatter());
//    }

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseSuffixPatternMatch(false);
	}

	/**
	 * 添加静态资源文件，外部可以直接访问地址
	 *
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		// 映射图片保存地址
		registry.addResourceHandler("uploadFile/userpic/**")
				.addResourceLocations("file:/Volumes/MacFile/WorkSpace/SpringBootTestFile/imageFile/userpic/");
//        registry.addResourceHandler("/static/**").addResourceLocations("/templates/**");
		// WebMvcConfigurer.super.addResourceHandlers(registry);
	}

	/**
	 * 跨域支持
	 * 
	 * @param registry
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedOrigins("*").allowCredentials(true)
				.allowedMethods("GET", "POST", "DELETE", "PUT").maxAge(3600 * 24);
	}

//	@Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//
//        registry.addViewController("/").setViewName("forward:/");
//
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//
//        //WebMvcConfigurer.super.addViewControllers(registry);
//
//    }
	@Bean
	public ErrorPageRegistrar errorPageRegistrar() {
		return new MyErrorPageRegistrar();
	}
}
