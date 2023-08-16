package com.maike.myblog.config;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @projectname BeautyDress
 * @author GEEKCJJ
 * @date 2019年9月6日 下午5:45:59
 * @description: 类上带有@Configuration的类，等同于spring的XML配置文件，好处是使用Java代码可以检查类型安全。通常还会搭配其他注解来实现不同的需求，如本例中，搭配的@EnableScheduling。
 *               在spring-boot中需要在类上添加@EnableScheduling注解来开启对计划任务的支持。
 *               在开启对计划任务的支持后，需要@Scheduled注解的配合。@Scheduled是方法上注解，添加该注解的方法即为单个计划任务。@Scheduled注解定义了计划任务的执行计划,有两种方式可以定义：
 *               1.@Scheduled(fixedRate = 5000)
 *               //通过@Scheduled声明该方法是计划任务，使用fixedRate属性每隔固定时间5秒执行一次
 *               2.@Scheduled(cron = “0 0/10 * * * ?”)
 *               //使用cron属性可按照指定时间执行，本例指的是每10分钟执行一次；
 */
@Configuration
@EnableScheduling
public class TimerTaskConfig {
	// @Resource
	// 具体的serviceimpl
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式

	@Scheduled(cron = "0 15 10 1 * ?") // 每月一号执行一次
	public void getToken() {
		final Calendar c = Calendar.getInstance();
		if (c.get(Calendar.DATE) == c.getActualMaximum(Calendar.DATE)) {
			// 是最后一天
			System.out.println("信息员等级升降级。。。。");
			System.out.println("getToken定时任务启动" + df.format(new Date()));
		}
	}
}
