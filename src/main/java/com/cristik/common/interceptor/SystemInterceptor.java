package com.cristik.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SystemInterceptor implements  HandlerInterceptor{
	/*Logger logger = Logger.getLogger(SystemInterceptor.class);*/
	Logger log = Logger.getLogger("FILE");

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		request.getSession().getServletContext().setAttribute("timeBegin", System.currentTimeMillis());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		request.getSession().getServletContext().setAttribute("base", request.getContextPath());
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		Long time =System.currentTimeMillis()-(Long)request.getSession().getServletContext().getAttribute("timeBegin");
		String message = request.getRequestURI()+"耗时:"+time+"ms";
		log.info(message);
	}

}
