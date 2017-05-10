package com.tams.bedezup.server.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tams.bedezup.domain.Good;
import com.tams.bedezup.server.GoodRestService;
import com.tams.bedezup.server.mapper.RestJsonMapper;

@RequestMapping("goods")
@Controller
public class GoodController {

	@Autowired
	private RestJsonMapper restJsonMapper;
	
	@Autowired
	private GoodRestService goodRestService;
	

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity <String> findGoodByIdEquals(@PathVariable("id") Long id) {
		HttpHeaders headers = new HttpHeaders();
		Good good = goodRestService.findGoodByIdEquals(id);
		headers.add("Content-Type", "application/json; charset=utf-8");
		
		if (good == null) {
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<String>(restJsonMapper.toJsonExcludes(good, "job"), headers, HttpStatus.OK);
	}
}
