//package com.maike.myblog.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.Set;
//
///**
// * @author geekcjj
// * @Description
// * @date 2020/4/5 8:56 下午
// * @Version 1.0
// */
////@WebFilter(filterName = "sessionFilter",urlPatterns = {"/*"})
//public class MyWebFilter implements Filter {
//
//    //标示符：表示当前用户未登录(可根据自己项目需要改为json样式)
//    String NO_LOGIN = "您还未登录";
//
//    //不需要登录就可以访问的路径(比如:注册登录等)
//    String[] includeUrls = new String[]{"/backManage","/backlogin","/uLogin","register","/","/static/**","/js/**","/css/**","/bootstrap/**"
//    ,"/fonts/**","/geekcjjback/**","/images/**","/login/**","/plugin/**","/sourceFile/**","/squireeditor/**"
//    ,"/summernote/**","/superSlide/**","waterfall"};
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("初始化filter");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("开始过滤filter");
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        HttpSession session = request.getSession(false);
//        String uri = request.getRequestURI();
//
//        System.out.println("filter url:"+uri);
//        //是否需要过滤
//        boolean needFilter = isNeedFilter(uri);
//
//        if (!needFilter) { //不需要过滤直接传给下一个过滤器
////            request.setCharacterEncoding("utf-8");
////            response.setCharacterEncoding("utf-8");
//            filterChain.doFilter(servletRequest, servletResponse);
//        } else { //需要过滤器
//            // session中包含user对象,则是登录状态
//            if(session!=null&&session.getAttribute("username") != null){
//                // System.out.println("user:"+session.getAttribute("user"));
//                filterChain.doFilter(request, response);
//            }else{
//                String requestType = request.getHeader("X-Requested-With");
//                //判断是否是ajax请求
//                if(requestType!=null && "XMLHttpRequest".equals(requestType)){
//                    response.getWriter().write(this.NO_LOGIN);
//                }else{
//                    //重定向到登录页(需要在static文件夹下建立此html文件)
//                    response.sendRedirect(request.getContextPath()+"/uLogin");
//                }
//                return;
//            }
//        }
//    }
//
//    /**
//     * @Author: xxxxx
//     * @Description: 是否需要过滤
//     * @Date: 2018-03-12 13:20:54
//     * @param uri
//     */
//    public boolean isNeedFilter(String uri) {
//
//        for (String includeUrl : includeUrls) {
//            if(includeUrl.equals(uri)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    @Override
//    public void destroy(){
//        System.out.println("我是过滤器的被销毁时调用的方法！，活不下去了................" );
//    }
//}
