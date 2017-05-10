package com.tams.bedezup.server.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.tams.bedezup.domain.Profile;

@Repository("profileDAO")
public interface ProfileDAO extends JpaRepository<Profile, Long>, JpaSpecificationExecutor<Profile>, ProfileDAOCustom {}
