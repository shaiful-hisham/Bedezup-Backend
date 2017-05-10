package com.tams.bedezup.server;

import java.util.ArrayList;
import java.util.List;

import com.tams.bedezup.domain.Job;

public interface JobRestService {

	public Job findJobByIdEquals(Long id);
	
	public ArrayList <Job> findJobList();
	
	public List <Job> findJobListByJobStatusCodeEquals(String jobStatusCode);
}
