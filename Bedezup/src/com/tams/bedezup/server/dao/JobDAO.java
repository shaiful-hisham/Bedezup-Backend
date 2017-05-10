package com.tams.bedezup.server.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.tams.bedezup.domain.Job;

@Repository("jobDAO")
public interface JobDAO extends JpaRepository <Job, Long>, JpaSpecificationExecutor <Job>, JobDAOCustom {}
