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

import com.tams.bedezup.domain.SystemUser;
import com.tams.bedezup.server.SystemUserRestService;

@RequestMapping("forgetpassword")
@Controller
public class ForgetPasswordController {

	private static Logger logger = Logger.getLogger(ForgetPasswordController.class);
	
	@Autowired
	private SystemUserRestService systemUserRestService;
	
	
	@RequestMapping(value = "/username", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<String> forgetPassword(@RequestBody String userName) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		
		ResponseEntity<String> response = null;
		SystemUser systemUser = null;
		
		try {
			// Json string will include double quote, remove it
			userName = userName.replace("\"", "");
			logger.debug("Username: " + userName);
			systemUser = systemUserRestService.findSystemUserByUserNameEquals(userName);
		}
		catch (Exception e) {
			//e.printStackTrace();
			logger.debug("Exception");
			response = new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
		}
		
		if (systemUser != null && systemUser.getProfile() != null) {
			logger.debug("Fullname: " + systemUser.getProfile().getFullName());
			response = new ResponseEntity<String>(headers, HttpStatus.OK);
		}
		else {
			logger.debug("Response: No user found.");
			response = new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
		}
		
		return response;
	}
}
