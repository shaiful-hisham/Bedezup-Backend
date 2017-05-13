package com.tams.bedezup.server.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;

import com.tams.bedezup.domain.SystemUser;

public class SystemUserDAOImpl implements SystemUserDAOCustom {
	
	private static Logger logger = Logger.getLogger(SystemUserDAOImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public SystemUser update(SystemUser systemUser) {
		return entityManager.merge(systemUser);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public SystemUser findSystemUserByUserNameAndPasswordEqual(String userName, String password) {
		TypedQuery<SystemUser> query = (TypedQuery<SystemUser>) entityManager.createQuery("FROM com.tams.bedezup.domain.SystemUser user WHERE user.userName = :userName AND user.password = :password");
		query.setParameter("userName", userName);
		query.setParameter("password", password);
		SystemUser systemUser = query.getSingleResult();
		logger.debug("User: " + systemUser.getUserName());
		
		return systemUser;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public SystemUser findSystemUserByEmailEquals(String email) {
		TypedQuery<SystemUser> query = (TypedQuery<SystemUser>) entityManager.createQuery("FROM com.tams.bedezup.domain.SystemUser user WHERE user.email = :email");
		query.setParameter("email", email);
		SystemUser systemUser = query.getSingleResult();
		
		return systemUser;
	}

	@SuppressWarnings("unchecked")
	@Override
	public SystemUser findSystemUserByUserNameEquals(String userName) {
		logger.debug("User: " + userName);
		TypedQuery<SystemUser> query = (TypedQuery<SystemUser>) entityManager.createQuery("FROM com.tams.bedezup.domain.SystemUser user WHERE user.userName = :userName");
		query.setParameter("userName", userName);
		SystemUser systemUser = query.getSingleResult();
		
		return systemUser;
	}
}
