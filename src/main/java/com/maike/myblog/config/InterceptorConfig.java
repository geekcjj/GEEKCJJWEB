//package com.maike.myblog.config;
//
//import com.maike.myblog.interceptor.AdminLoginInterceptor;
//import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//
///**
// * @ClassName InterceptorConfig
// * @Description 拦截器配置
// * @Author Zheng
// * @Date 2018年1月10日 上午8:40:35
// */
//@Configuration
//public class InterceptorConfig extends WebMvcConfigurerAdapter {
//
//	@Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//		/** 多个拦截器组成一个拦截器链
//         *  addPathPatterns 用于添加拦截规则
//         *  excludePathPatterns 用户排除拦截
//		 */
//        registry.addInterceptor(new AdminLoginInterceptor()).addPathPatterns("/bacManage/**").addPathPatterns("/bacManage/**/**").addPathPatterns("/bacManage/**/**/**")
//        .excludePathPatterns("/**").excludePathPatterns("/**/**").excludePathPatterns("/**/**/**")
////        .excludePathPatterns("/category/**","/industry/**","/people/around/**")
////        .excludePathPatterns("/customerUser/noAuth/**")
////        .excludePathPatterns("/quartz/**")
////        .excludePathPatterns("/college/**")
////        .excludePathPatterns("/payNotify/**")
////        .excludePathPatterns("/application/cooperation/updateStatus1")
////        .excludePathPatterns("/application/cooperation/updateStatus2")
//        // swagger白名单
//        .excludePathPatterns("/webjars/**")
//        .excludePathPatterns("/swagger-ui.html")
//        .excludePathPatterns("/v2/**")
//        .excludePathPatterns("/swagger-resources/**");
//        super.addInterceptors(registry);
//    }
//}
