package com.tams.bedezup.server.dao;

import com.tams.bedezup.domain.SystemUser;

public interface SystemUserDAOCustom {

	public SystemUser update(SystemUser systemUser);
	
	public SystemUser findSystemUserByUserNameAndPasswordEqual(String userName, String password);
}
