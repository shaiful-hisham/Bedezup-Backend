package com.tams.bedezup.server.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.tams.bedezup.domain.Good;

@Repository("goodDAO")
public interface GoodDAO extends JpaRepository <Good, Long>, JpaSpecificationExecutor <Good>, GoodDAOCustom {}
