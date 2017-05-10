package com.tams.bedezup.server.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.tams.bedezup.shared.UserState;

public class RestInterceptor extends HandlerInterceptorAdapter {
	
	private static Logger logger = Logger.getLogger(RestInterceptor.class);

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Enumeration<String> headerNames = request.getHeaderNames();

        if (headerNames != null) {
        	
        	while (headerNames.hasMoreElements()) {    
        		String headerName = headerNames.nextElement();
        		logger.debug("Header -> (" + headerName + " : " + request.getHeader(headerName) + ")");
            }
        }
        
        // Request must contains cookie with session id
        if (!request.getSession().getId().equals(getSessionIdFromCookie(request))) {
        	logger.debug("Exception trap 1: Request is unauthorized");
        	request.getRequestDispatcher("/app/rest/exceptions/" + HttpStatus.FORBIDDEN).forward(request, response);
        	return false;
        }
        else {
        	UserState userState = (UserState) request.getSession().getAttribute(UserState.USER_STATE);
        	
        	if (userState == null) {        	
        		logger.debug("Exception trap 2: Request is unauthorized");
            	request.getRequestDispatcher("/app/rest/exceptions/" + HttpStatus.FORBIDDEN).forward(request, response);
            	return false;
        	}
        }
        
        logger.debug("Request is authorized");
        return super.preHandle(request, response, handler);
	}
	
	private String getSessionIdFromCookie(HttpServletRequest request) {
		String authorizationHeader = request.getHeader("cookie");
		String sessionId = new String();
		
		if (authorizationHeader != null) {
			sessionId = authorizationHeader.substring("JSESSIONID=".length());
			logger.debug("Cookie: " + sessionId);
			return sessionId;
		}
		
		return new String();
	}
}
