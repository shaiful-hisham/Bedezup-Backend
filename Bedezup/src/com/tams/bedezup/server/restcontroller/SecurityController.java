package com.tams.bedezup.server.restcontroller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tams.bedezup.domain.SystemUser;
import com.tams.bedezup.server.SystemUserRestService;
import com.tams.bedezup.server.mapper.RestJsonMapper;
import com.tams.bedezup.shared.UserState;

@RequestMapping("security")
@Controller
public class SecurityController {
	
	private static Logger logger = Logger.getLogger(SecurityController.class);
	
	@Autowired
	private RestJsonMapper restJsonMapper;
		
	@Autowired
	private SystemUserRestService systemUserRestService;


	@RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<String> login(HttpSession session, @RequestBody String json) {
		HttpHeaders headers = generateNormalHeaders(session);
		SystemUser systemUser = (SystemUser) restJsonMapper.fromJsonToObject(json, SystemUser.class);
		ResponseEntity<String> response = null;
		logger.debug("Json received: " + restJsonMapper.toJson(systemUser));
		
		try {
			// Can implement secure login here
			systemUser = systemUserRestService.findSystemUserByUserNameAndPasswordEqual(systemUser.getUserName(), systemUser.getPassword());
		}
		catch (Exception e) {
			response = new ResponseEntity<String>(headers, HttpStatus.FORBIDDEN);
			logger.error(e);
		}
		
		// Passed authorization
		if (systemUser != null && systemUser.getId() != null) {
			UserState userState = new UserState();
			userState.setSessionId(session.getId());
			userState.setStateObject(UserState.SYSTEM_USER_ID, systemUser.getId());
			//userState.setStateObject(UserState.LAST_LOGIN, systemUser.getLastLogin());
			//userState.setStateObject(UserState.LAST_LOGOUT, systemUser.getLastLogout());
			session.setAttribute(UserState.USER_STATE, userState);
			
			headers = generateAuthenticatedHeaders(session);
			response = new ResponseEntity<String>(systemUser.getId().toString(), headers, HttpStatus.OK);
		}
		else {
			response = new ResponseEntity<String>(headers, HttpStatus.FORBIDDEN);
		}
		
		return response;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<String> logout(HttpSession session, @RequestBody String json) {
		HttpHeaders headers = generateNormalHeaders(session);
		UserState userState = (UserState) session.getAttribute(UserState.USER_STATE);
		
		if (userState != null) {
			session.removeAttribute(UserState.USER_STATE);
		}
		
		session.invalidate();
		ResponseEntity<String> response = new ResponseEntity<String>(headers, HttpStatus.OK);
				
		return response;
	}
	
	private HttpHeaders generateNormalHeaders(HttpSession session) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		
		return headers;
	}
	
	private HttpHeaders generateAuthenticatedHeaders(HttpSession session) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		headers.add("Authorization", "Bearer " + session.getId());
		
		logger.debug("Session id: " + session.getId());
		return headers;
	}
}
