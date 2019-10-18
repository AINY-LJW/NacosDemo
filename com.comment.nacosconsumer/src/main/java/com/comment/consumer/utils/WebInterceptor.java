package com.comment.consumer.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.comment.common.User;

/**
 * 拦截器
 * <p>TODO 类描述</p>
 *
 * <p><br>
 *
 * @author lijiawen
 * @version 2019年2月20日
 */

@Component
public class WebInterceptor implements HandlerInterceptor{
	//拦截后的方法写在preHandle里面。只有拦截后才return false; 放行最后要return true;默认是return false;
	 @Override
	    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
		 User loginUser = (User)httpServletRequest.getSession().getAttribute("loginUser");
	        String requestURI = httpServletRequest.getRequestURI();
	        System.err.println(requestURI);
//	        if(loginUser==null){
//	            httpServletResponse.sendRedirect("/login");
//	            return false;
//	        }
	        return true;
	    }
	 
	    @Override
	    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
	 
	    }
	 
	    @Override
	    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
	 
	    }
}
