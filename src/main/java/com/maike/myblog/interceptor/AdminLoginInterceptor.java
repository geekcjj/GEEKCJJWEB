package com.maike.myblog.interceptor;

import com.maike.myblog.enums.ResultEnum;
import com.maike.myblog.token.CustomerTokenUtil;
import com.maike.myblog.token.TimeTokenUtil;
import com.maike.myblog.utils.CookieUtil;
import com.maike.myblog.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @projectname BeautyDress
 * @author GEEKCJJ
 * @date 2019年8月22日 下午9:43:39
 * @description:
 *
 */
//@Configuration
//@Component
//public class AdminLoginInterceptor implements HandlerInterceptor {
public class AdminLoginInterceptor extends HandlerInterceptorAdapter {
	Logger logger = LoggerFactory.getLogger(AdminLoginInterceptor.class);
	private UrlPathHelper urlPathHelper = new UrlPathHelper();
    /**
     *
     * 用于处理自动登录
     *
     * preHandle方法是进行处理器拦截用的，该方法将在Controller处理之前进行调用，SpringMVC中的Interceptor拦截器是链式的，可以同时存在
     * 多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在
     * Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返
     * 回值为false，当preHandle的返回值为false的时候整个请求就结束了。
     */
	//返回值表示我们是否将当前的请求拦截下来
	//如果false请求将被终止
	//如果true请求继续
	//handler表示当前被拦截的请求方法
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("AdminLoginInterceptor....验证用户名，密码是否正确....");
		//Cookie[] cookies = request.getCookies();
		HttpSession session=request.getSession();
		//首页路径以及登录放行
//		if ("/index".equals(request.getRequestURI()) || "/loging".equals(request.getRequestURI())) {
//			return true;
//		}
//		request.setCharacterEncoding("utf-8");//设置请求流编码格式
//		response.setContentType("text/html;charset=utf-8");//设置http输出格式
//		response.setCharacterEncoding("utf-8");//设置字符编码格式
//		boolean flag = false;
//		String timeToken = request.getParameter("timeToken");
//		String token = request.getParameter("token");
//		Boolean isCustomer = false;
//		if(null != timeToken){
//			/**
//			 * 客户端令牌授权
//			 */
//			isCustomer = true;
//			Integer index = CustomerTokenUtil.validateToken(timeToken);
//			if(index.intValue() == 1){
//				flag = true;
//			}else{
//				String backMsg = "令牌失效了";
//				if(index.intValue() == -1){
//					backMsg = "令牌参数错误";
//				}
//				if(index.intValue() == -2){
//					backMsg = "令牌不合法";
//				}
//				if(index.intValue() == -3){
//					backMsg = "令牌失效了，请重新登录";
//				}
//				response.getWriter().print(Result.error(ResultEnum.AUTH_ERROR.getCode(), backMsg));
//			}
//		}else{
//			/**
//			 * 分销商时效令牌
//			 */
//			String backMsg = TimeTokenUtil.validateToken(token);
//			if("success".equals(backMsg)){
//				flag = true;
//			}else{
//				response.getWriter().print(Result.error(ResultEnum.AUTH_ERROR.getCode(), backMsg));
//			}
//		}
//		logger.info("时效令牌拦截器 {};flag={};isCustomer={}",token,flag,isCustomer);
		if(session.getAttribute("userName")==null||session.getAttribute("userName")=="") {
			Cookie userNameCookie = CookieUtil.getCookie(request, "userName");
			if (userNameCookie == null || userNameCookie.getValue() == null || userNameCookie.getValue() == "") {
				response.sendRedirect("/backlogin");
				return false;
			}else{
				return true;
			}
		}
		return true;
    }

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
						   ModelAndView modelAndView) throws Exception {
		System.out.println("执行postHandle当前时间==>"+System.currentTimeMillis());
		System.out.println("我是postHandle");
	}
	/**
	 * afterCompletion是在整个请求完成之后执行
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
	        throws Exception {

	    //super.afterCompletion(request, response, handler, ex);
	    System.out.println("执行afterCompletion当前时间==>"+System.currentTimeMillis());
	    System.out.println("我是afterCompletion");
	}
}
