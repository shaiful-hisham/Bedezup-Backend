package com.tams.bedezup.server.restcontroller;

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

import com.tams.bedezup.domain.Profile;
import com.tams.bedezup.domain.SystemUser;
import com.tams.bedezup.server.ProfileRestService;
import com.tams.bedezup.server.SystemUserRestService;
import com.tams.bedezup.server.mapper.RestJsonMapper;

@RequestMapping("signup")
@Controller
public class SignUpController {
	
	private static Logger logger = Logger.getLogger(SignUpController.class);
	
	@Autowired
	private SystemUserRestService systemUserRestService;
	
	@Autowired
	private ProfileRestService profileRestService;
	
	@Autowired
	private RestJsonMapper restJsonMapper;
	

	@RequestMapping(value = "/normaluser", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<String> signUpNormalUser(@RequestBody String json) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		ResponseEntity<String> response = null;
		
		SystemUser systemUser = (SystemUser) restJsonMapper.fromJsonToObject(json, SystemUser.class);
		//systemUser.setStatus(SystemUserStatus.Active);
		Profile profile = systemUser.getProfile();
		logger.debug("Json string: " + restJsonMapper.toJson(systemUser));
		
		profile.setSystemUser(systemUser);
		systemUser.setProfile(profile);
		
		if (systemUserRestService.save(systemUser) != null) {
			response = new ResponseEntity<String>(headers, HttpStatus.CREATED);
		}
		else {
			response = new ResponseEntity<String>(headers, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		return response;
	}
	
	@RequestMapping(value = "/rider", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<String> signUpRider(@RequestBody String json) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		ResponseEntity<String> response = null;
		
		SystemUser systemUser = (SystemUser) restJsonMapper.fromJsonToObject(json, SystemUser.class);
		Profile profile = systemUser.getProfile();
		logger.debug("Json string: " + restJsonMapper.toJson(systemUser));
		
		profile.setSystemUser(systemUser);
		systemUser.setProfile(profile);
		
		if (systemUserRestService.save(systemUser) != null) {
			response = new ResponseEntity<String>(headers, HttpStatus.CREATED);
		}
		else {
			response = new ResponseEntity<String>(headers, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		return (response == null ? new ResponseEntity<String>(headers, HttpStatus.OK) : response);
	}
}
