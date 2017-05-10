package com.tams.bedezup.server.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.tams.bedezup.domain.SystemUser;

public class SystemUserDAOImpl implements SystemUserDAOCustom {
	
	@PersistenceContext
	private EntityManager entityManager;
	

	@SuppressWarnings("unchecked")
	@Override
	public SystemUser findSystemUserByUserNameAndPasswordEqual(String userName, String password) {
		TypedQuery<SystemUser> query = (TypedQuery<SystemUser>) entityManager.createQuery("FROM com.tams.bedezup.domain.SystemUser user WHERE user.userName = :userName AND user.password = :password");
		query.setParameter("userName", userName);
		query.setParameter("password", password);
		SystemUser systemUser = query.getSingleResult();
		
		return systemUser;
	}


	@Override
	public SystemUser update(SystemUser systemUser) {
		return entityManager.merge(systemUser);
	}
}
