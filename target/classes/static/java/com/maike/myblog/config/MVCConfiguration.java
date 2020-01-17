package com.maike.myblog.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.maike.myblog.interceptor.UserLoginInterceptor;

/**
 * @projectname BeautyClothes
 * @author GEEKCJJ
 * @date 2019年8月13日 上午11:18:36
 * @description:
 *
 */
@Component
public class MVCConfiguration implements WebMvcConfigurer{
	//@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/login").excludePathPatterns("/static/**");
//    }

	/**
     * 添加静态资源文件，外部可以直接访问地址
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //映射图片保存地址
        registry.addResourceHandler("uploadFile/userpic/**").addResourceLocations("file:/Volumes/MacFile/WorkSpace/SpringBootTestFile/imageFile/userpic/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/template/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("classpath:/static/").addResourceLocations("/static/geekcjjback/**");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("forward:/index.html");
        //registry.addViewController("/geekcjjback/").setViewName("forward:/geekcjjback/index.html");
        //registry.addViewController("/geekcjjback/").setViewName("forward:/login.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);

        WebMvcConfigurer.super.addViewControllers(registry);

    }
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserLoginInterceptor())
                .addPathPatterns("/backManage","/backManage/**")
                .excludePathPatterns("/backlogin");
    }
}
