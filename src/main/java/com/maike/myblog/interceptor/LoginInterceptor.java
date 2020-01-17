package com.maike.myblog.interceptor;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.UrlPathHelper;

import com.maike.myblog.utils.CookieUtil;
import com.maike.myblog.utils.EncryptionUtil;

/**
 * @projectname BeautyDress
 * @author GEEKCJJ
 * @date 2019年8月22日 下午9:43:39
 * @description:
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
//	private UrlPathHelper urlPathHelper = new UrlPathHelper();
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("DemoInterceptor....验证用户名，密码是否正确....");
//        response.sendRedirect("/login");
//        return true;
//    }
	/**
	 * 
	 * 用于处理自动登录
	 *
	 * preHandle方法是进行处理器拦截用的，该方法将在Controller处理之前进行调用，SpringMVC中的Interceptor拦截器是链式的，可以同时存在
	 * 多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在
	 * Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返
	 * 回值为false，当preHandle的返回值为false的时候整个请求就结束了。
	 */
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//	        throws Exception {
//	    HttpSession session = request.getSession();
//	    //User user = (User) session.getAttribute("user");
//
//	    // 已登录
////	    if (user != null) {
////	        return true;
////	    } else {
//	        // 从cookie中取值
//	        Cookie rememberme = null;//CookieUtils.getCookie(request,CookieConstantTable.RememberMe);
//	        if (rememberme != null) {
//	            String cookieValue = EncryptionUtil.base64Decode(rememberme.getValue());
//
//	            String[] cValues = cookieValue.split(":");
//	            if (cValues.length == 2) {
//	                String usernameByCookie = cValues[0]; // 获取用户名
//	                String uuidByCookie = cValues[1]; // 获取UUID值
//	                // 到数据库中查询自动登录记录
//	                //Logins Logins = loginsService.selectByUsernameAndSeries(usernameByCookie,uuidByCookie);
//	                if (null != null) {
//	                    //String savedToken = Logins.getToken(); // 数据库中保存的密文
//
//	                    // 获取有效时间
//	                    //Date savedValidtime = Logins.getValidTime();
//	                    Date currentTime = new Date();
//
//	                    // 如果还在cookie有效期之内，继续判断是否可以自动登录
//	                    if (currentTime.before(null)) {
//	                        //User u = userService.selectByUserName(usernameByCookie);
//	                        if (null != null) {
//	                            Calendar calendar = Calendar.getInstance();
//	                            //calendar.setTime(Logins.getValidTime());
//	                            // 精确到分的时间字符串
//	                            String timeString = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH)
//	                                    + "-" + calendar.get(Calendar.DAY_OF_MONTH) + "-"
//	                                    + calendar.get(Calendar.HOUR_OF_DAY) + "-" + calendar.get(Calendar.MINUTE);
//	                            // 为了校验而生成的密文
////	                            String newToken = EncryptionUtil.sha256Hex(u.getUsername() + "_" + u.getPassword() + "_"
////	                                    + timeString + "_" + CookieConstantTable.salt);
//
//	                            // 校验sha256加密的值，如果不一样则表示用户部分信息已被修改，需要重新登录
//	                            if (null!=null) {
//	                                /**
//	                                 * 为了提高安全性，每次登录之后都更新自动登录的cookie值
//	                                 */
//	                                // 更新cookie值
//	                                String uuidNewString = UUID.randomUUID().toString();
//	                                //String newCookieValue = EncryptionUtil.base64Encode(u.getUsername() + ":" + uuidNewString);
////	                                CookieUtil.editCookie(request, response, CookieConstantTable.RememberMe,
////	                                        newCookieValue, null);
//
//	                                // 更新数据库
//	                                //Logins.setSeries(uuidNewString);
//	                                //loginsService.updateByPrimaryKeySelective(Logins);
//
//	                                /**
//	                                 * 将用户加到session中，不退出浏览器时就只需判断session即可
//	                                 */
//	                                //session.setAttribute("user", u);
//	                                //session.setAttribute(Constant.SESSION_ACCOUNTID, u.getId());
//	                                //session.setAttribute(Constant.SESSION_LOGINNAME, u.getUsername());
//	                                //Object name = session.getAttribute(Constant.SESSION_LOGINNAME);
//
//	                                return true;  //校验成功，此次拦截操作完成
//	                            } else { // 用户部分信息被修改，删除cookie并清空数据库中的记录
//	                                CookieUtil.delCookie(response, rememberme);
//	                                //loginsService.deleteByPrimaryKey(Logins.getId());
//	                            }
//	                        }
//	                    } else { // 超过保存的有效期，删除cookie并清空数据库中的记录
//	                        CookieUtil.delCookie(response, rememberme);
//	                        //loginsService.deleteByPrimaryKey(Logins.getId());
//	                    }
//	                }
//	            }
//	        }
//	        //将来源地址存放在session中，登录成功之后跳回原地址
//	      /*  String callback = request.getRequestURL().toString();
//	        session.setAttribute("callback", callback);
//	        response.sendRedirect(
//	                request.getContextPath() + "/login.html?callback=" + callback);*/
//	    //}
//	    return false;
//
//	}

//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//	        throws Exception {
//
//	    super.afterCompletion(request, response, handler, ex);
//	}
}
