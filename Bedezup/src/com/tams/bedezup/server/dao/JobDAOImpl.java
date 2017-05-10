package com.tams.bedezup.server.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.tams.bedezup.domain.Job;

public class JobDAOImpl implements JobDAOCustom {

	@PersistenceContext
	private EntityManager entityManager;

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Job> findJobListByJobStatusCodeEquals(String jobStatusCode) {
		List<Job> jobList = new ArrayList<Job>();
		TypedQuery<Job> query = (TypedQuery<Job>) entityManager.createQuery("FROM com.tams.bedezup.domain.Job job WHERE job.jobStatus.code = :jobStatusCode ORDER BY job.id DESC");
		query.setParameter("jobStatusCode", jobStatusCode);
		jobList = query.getResultList();
		
		return jobList;
	}
}
