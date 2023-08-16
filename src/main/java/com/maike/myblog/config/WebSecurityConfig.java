//package com.maike.myblog.config;
//
//import com.maike.myblog.handle.MyAuthenticationFailHandler;
//import com.maike.myblog.handle.MyAuthenticationSuccessHandler;
//import com.maike.myblog.service.MyCustomUserService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.csrf.CsrfFilter;
//import org.springframework.web.filter.CharacterEncodingFilter;
//
///**
// * @author geekcjj
// * @version 1.0
// * @description WebSecurityConfiguration
// * @date 2020/2/12 11:39 下午
// */
//@Configuration
////@EnableWebSecurity
////@EnableGlobalMethodSecurity(prePostEnabled = true)
////@Order(Ordered.HIGHEST_PRECEDENCE)ACCESS_OVERRIDE_ORDER
////@Order(SecurityProperties.DEFAULT_FILTER_ORDER)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
//
//    private MyAuthenticationFailHandler myAuthenticationFailHandler;
//    @Bean
//    UserDetailsService customUserService() {
//        return new MyCustomUserService();
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // 使用自定义UserDetailsService
//        //auth.userDetailsService(customUserService()).passwordEncoder(new BCryptPasswordEncoder());
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("123456")
//                .roles("USER");
//        //auth.jdbcAuthentication()...
////        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())   //在Spring Security 5.0中新增了多种加密方式，页改变了密码的格式
////                .withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1", "VIP2")
////                .and()
////                .withUser("lisi").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP2", "VIP3")
////                .and()
////                .withUser("wangwu").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1", "VIP3");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .exceptionHandling()
////                .authenticationEntryPoint(unauthorizedHandler)
////                .accessDeniedHandler(accessDeniedHandler)
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and().authorizeRequests().antMatchers("/**","/backManage").permitAll(); // "/"：应用首页所以用户都可以访问
////        http.formLogin().loginProcessingUrl("/")
////                //　自定义的登录验证成功或失败后的去向
////                .successHandler(myAuthenticationSuccessHandler).failureHandler(myAuthenticationFailHandler)
////                // 禁用csrf防御机制(跨域请求伪造)，这么做在测试和开发会比较方便。
////                .and().rememberMe().tokenValiditySeconds(3600).key("user").and().csrf().disable();
//        http.formLogin()
//                .failureHandler(myAuthenticationFailHandler) // 自定义登录失败处理
//                .successHandler(myAuthenticationSuccessHandler) // 自定义登录成功处理
//                .and()
//                .authorizeRequests()  //定义哪些url需要保护，哪些url不需要保护
//                .anyRequest().authenticated()//任意请求需要登录
//                .and()
//                .formLogin()//开启formLogin默认配置
//                .loginPage("/uLogin").permitAll()//请求时未登录跳转接口
//                .failureUrl("/uLogin")//用户密码错误跳转接口
//                .defaultSuccessUrl("/",true)//登录成功跳转接口
//                .loginProcessingUrl("/uLogin")//post登录接口，登录验证由系统实现
//                .usernameParameter("username")	//要认证的用户参数名，默认username
//                .passwordParameter("password")	//要认证的密码参数名，默认password
//                .and()
//                .logout()//配置注销
//                .logoutUrl("/logout")//注销接口
//                .logoutSuccessUrl("/").permitAll()//注销成功跳转接口
//                .deleteCookies("userName") //删除自定义的cookie
//                .and()
//                .csrf().disable();           //禁用csrf
//        //解决中文乱码问题
//        CharacterEncodingFilter filter = new CharacterEncodingFilter();
//        filter.setEncoding("UTF-8");
//        filter.setForceEncoding(true);
//        http.addFilterBefore(filter, CsrfFilter.class);
//        //定制请求的授权规则
////        http.authorizeRequests().antMatchers("/").permitAll()
////                .antMatchers("/level1/**").hasRole("VIP1")
////                .antMatchers("/level2/**").hasRole("VIP2")
////                .antMatchers("/level3/**").hasRole("VIP3");
////        //开启自动配置的登陆功能，效果，如果没有登陆，没有权限就会来到登陆页面
////        http.formLogin().usernameParameter("user").passwordParameter("pwd").loginPage("/userlogin");
////        //1、 /login 来到登陆页
////        //2、重定向到/login?error表示登陆失败
////        //3、更多详细功能
////        //4、默认post形式的 /login 代表处理登陆
////        //5、一旦定制loginPage  那么 loginPage的post请求就是登陆
////        //开启自动配置的注销功能
////        http.logout().logoutSuccessUrl("/"); //注销成功以后来到首页
////        //1、访问/logout 表示用户注销。清空 session
////        //2、注销成功会返回 /login?logout 页面
////        //3、默认post形式的 /login代表处理登陆
////        //开启记住我功能
////        http.rememberMe().rememberMeParameter("remeber");
////        //登陆成功以后，将cookie发给浏览器保存，以后访问页面带上这个cookie，只要通过检查就可以免登陆
////        //点击注销会删除cookie
//    }
//    @Override
//    public void configure(WebSecurity web) {
//        //对于在header里面增加token等类似情况，放行所有OPTIONS请求。
//        web.ignoring().antMatchers(HttpMethod.GET,"/**");
//        web.ignoring().antMatchers(HttpMethod.POST,"/**");
//        web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
//        web.ignoring().antMatchers(HttpMethod.HEAD,"/**");
//        web.ignoring().antMatchers(HttpMethod.TRACE,"/**");
//        //解决静态资源被拦截的问题
//        web.ignoring().antMatchers("/**");
//        web.ignoring().antMatchers("/css/**","/js/**","/bootstrap/**","/images/**");
////        web.ignoring().antMatchers("/bootstrap/**");
////        web.ignoring().antMatchers("/js/**");
////        web.ignoring().antMatchers("/css/**");
////        web.ignoring().antMatchers("/js/**");
//        web.ignoring().antMatchers("/login/**","/superSlide/images/**","/plugin/SuperSlide/js/**");
//        web.ignoring().antMatchers("/squireeditor/**","/summernote/**","/geekcjjback/**","/sourceFile/**");
////        web.ignoring().antMatchers("/login/**");
////        web.ignoring().antMatchers("/superSlide/images/**");
////        web.ignoring().antMatchers("/plugin/SuperSlide/js/**");
////        web.ignoring().antMatchers("/squireeditor/**");
////        web.ignoring().antMatchers("/summernote/**");
////        web.ignoring().antMatchers("/geekcjjback/**");
////        web.ignoring().antMatchers("/images/**");
////        web.ignoring().antMatchers("/sourceFile/**");
//        //解决服务注册url被拦截的问题
////        web.ignoring().antMatchers("/swagger-ui.html","/doc.html");
////        web.ignoring().antMatchers("/webjars/**");
////        web.ignoring().antMatchers("/v2/**");
//    }
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }
////    @Bean
////    public AuthenticationProvider authenticationProvider() {
////        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
////        //对默认的UserDetailsService进行覆盖
////        authenticationProvider.setUserDetailsService(customUserService);
////        authenticationProvider.setPasswordEncoder(myPasswordEncoder);
////        return authenticationProvider;
////    }
//}
