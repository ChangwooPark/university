package com.capstone.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
public class Interceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub

		// System.out.println("URL : " + request.getRequestURI());

		try {

			if (request.getRequestURI().equals("loginUi.do")) {
				return true;
			}
			if (request.getRequestURI().equals("")) {
				return true;
			}
			if (request.getSession().getAttribute("admin") == null) {
				response.sendRedirect("");
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}

}
