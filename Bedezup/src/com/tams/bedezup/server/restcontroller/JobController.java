package com.tams.bedezup.server.restcontroller;

import java.util.List;

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

import com.tams.bedezup.domain.Job;
import com.tams.bedezup.server.JobRestService;
import com.tams.bedezup.server.mapper.RestJsonMapper;


@RequestMapping("jobs")
@Controller
public class JobController {
	
	private static Logger logger = Logger.getLogger(JobController.class);
	
	@Autowired
	private RestJsonMapper restJsonMapper;
	
	@Autowired
	private JobRestService jobRestService;
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity <String> findJobByIdEquals(@PathVariable("id") Long id) {
		HttpHeaders headers = new HttpHeaders();
		Job job = jobRestService.findJobByIdEquals(id);
		headers.add("Content-Type", "application/json; charset=utf-8");
		
		if (job == null) {
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<String>(restJsonMapper.toJson(job), headers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity <String> findJobList() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		List <Job> jobList = jobRestService.findJobList();
		
		return new ResponseEntity<String>(restJsonMapper.toJsonArray(jobList), headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/jobstatus/{jobStatusCode}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity <String> findJobListByJobStatusCodeEquals(@PathVariable("jobStatusCode") String jobStatusCode) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		List <Job> jobList = jobRestService.findJobListByJobStatusCodeEquals(jobStatusCode);
		
		String jsonString = restJsonMapper.toJsonArray(jobList);
		logger.debug("Json strig: " + jsonString);
		
		return new ResponseEntity<String>(jsonString, headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/jobstatus/{jobStatusCode}?size={size}&page={page}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity <String> findJobListByJobStatusCodeEqualsByPagination(@PathVariable("jobStatusCode") String jobStatusCode) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		List <Job> jobList = jobRestService.findJobListByJobStatusCodeEquals(jobStatusCode);
		
		String jsonString = restJsonMapper.toJsonArray(jobList);
		logger.debug("Json strig: " + jsonString);
		
		return new ResponseEntity<String>(jsonString, headers, HttpStatus.OK);
	}
}
