package com.maike.myblog;

import com.maike.myblog.config.MVCConfiguration;
import com.maike.myblog.interceptor.AdminLoginInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @projectname BeautyClothes
 * @author GEEKCJJ
 * @date 2019年8月13日 上午10:31:25
 * @description:
 *
 */
@SpringBootApplication
@MapperScan({ "com.maike.myblog.mapper" })
//@ComponentScan(basePackages = {"com.maike.myblog.*"})
//@EnableCaching
//@EnableTransactionManagement
//@ServletComponentScan
//@Import({AdminLoginInterceptor.class, MVCConfiguration.class})
//@ComponentScan(basePackages = {"com.maike.myblog","com.maike.myblog.interceptor","com.maike.myblog.service","com.maike.myblog.controller"})
public class GeekPlusWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(GeekPlusWebApplication.class, args);
	}
}
