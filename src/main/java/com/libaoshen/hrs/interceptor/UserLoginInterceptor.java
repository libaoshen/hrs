package com.libaoshen.hrs.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 管理员登录拦截器
 * @author libaoshen
 *
 */
public class UserLoginInterceptor extends HandlerInterceptorAdapter {
	//拦截执行前方法
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestURI = request.getRequestURI(); 
		String host = request.getContextPath();
		//String adminname = request.getParameter("adminname");
		
		//排除登录路径,同时对登录路径做处理
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
			
		if(obj == null || "".equals(obj)){
			response.sendRedirect(host+"/user/showLogin");  
			return false;
		}
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

}
