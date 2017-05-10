package com.tams.bedezup.server.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.tams.bedezup.domain.SystemUser;

@Repository("systemUserDAO")
public interface SystemUserDAO extends JpaRepository<SystemUser, Long>, JpaSpecificationExecutor<SystemUser>, SystemUserDAOCustom {}
