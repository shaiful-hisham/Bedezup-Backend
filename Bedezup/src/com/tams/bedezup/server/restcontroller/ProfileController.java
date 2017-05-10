package com.tams.bedezup.server.restcontroller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tams.bedezup.domain.Profile;
import com.tams.bedezup.server.ProfileRestService;
import com.tams.bedezup.server.mapper.RestJsonMapper;

@RequestMapping("profiles")
@Controller
public class ProfileController {

	private static Logger logger = Logger.getLogger(ProfileController.class);
	
	@Autowired
	private RestJsonMapper restJsonMapper;
	
	@Autowired
	private ProfileRestService profileRestService;
	
	
	@RequestMapping(value = "/{systemUserId}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity <String> findProfileBySystemUserIdEquals(@PathVariable("systemUserId") Long systemUserId) {
		HttpHeaders headers = new HttpHeaders();
		Profile profile = profileRestService.findProfileBySystemUserIdEquals(systemUserId);
		headers.add("Content-Type", "application/json; charset=utf-8");
		
		if (profile == null) {
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		}
		
		//What The Heck: To avoid cyclic problem in json one to one relationship where cannot lazy loading
		profile.setSystemUser(null);
		String jsonString = restJsonMapper.toJsonExcludes(profile, "systemUser");
		logger.debug("Json string: " + jsonString);
		
		return new ResponseEntity<String>(jsonString, headers, HttpStatus.OK);
	}
}
