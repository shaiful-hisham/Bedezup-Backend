package com.tams.bedezup.server.restcontroller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("exceptions")
@Controller
public class ExceptionController {

	private static Logger logger = Logger.getLogger(ExceptionController.class);

	
	@RequestMapping(value = "/{errorCode}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity <String> responseException(@PathVariable("errorCode") String errorCode) {
		logger.debug("Exception: Error code: " + errorCode);
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<String> response = new ResponseEntity<String>(headers, HttpStatus.UNAUTHORIZED);
		
		if (HttpStatus.FORBIDDEN.toString().equals(errorCode)) {
			response = new ResponseEntity<String>(headers, HttpStatus.FORBIDDEN);
		}
		
		return response;
	}
}
