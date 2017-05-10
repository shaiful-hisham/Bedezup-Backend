package com.tams.bedezup.server.dao;

import com.tams.bedezup.domain.Profile;

public interface ProfileDAOCustom {
	
	public Profile findProfileBySystemUserIdEquals(Long systemUserId);
}
