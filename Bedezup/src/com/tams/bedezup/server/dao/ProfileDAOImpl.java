package com.tams.bedezup.server.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.tams.bedezup.domain.Profile;

public class ProfileDAOImpl implements ProfileDAOCustom {
	
	@PersistenceContext
	private EntityManager entityManager;

	
	@SuppressWarnings("unchecked")
	@Override
	public Profile findProfileBySystemUserIdEquals(Long systemUserId) {
		TypedQuery<Profile> query = (TypedQuery<Profile>) entityManager.createQuery("FROM com.tams.bedezup.domain.Profile profile where profile.systemUser.id = :systemUserId");
		query.setParameter("systemUserId", systemUserId);
		Profile profile = query.getSingleResult();
		
		return profile;
	}
}
