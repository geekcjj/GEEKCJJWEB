package com.maike.myblog.config;

//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.session.data.redis.config.ConfigureRedisAction;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author geekcjj
 * @Description
 * @date 2020/2/24 11:42 下午
 * @Version 1.0
 */
//@Configuration
//@EnableCaching //开启注解
////maxInactiveIntervalInSeconds session超时时间,单位秒
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 600)
//public class RedisConfig {
//    //这里有个小坑，如果服务器用的是云服务器，不加这个会报错
//    @Bean
//    public static ConfigureRedisAction configureRedisAction() {
//        return ConfigureRedisAction.NO_OP;
//    }
//    //session策略，这里配置的是Header方式（有提供Header，Cookie等方式）
//    //@Bean
////    public HttpSessionStrategy httpSessionStrategy() {
////        return new HeaderHttpSessionStrategy();
////    }
//}
