package com.tams.bedezup.server.dao;

import java.util.List;

import com.tams.bedezup.domain.Job;


public interface JobDAOCustom {
	
	public List <Job> findJobListByJobStatusCodeEquals(String jobStatusCode);
}
