package com.tams.bedezup.server;

import com.tams.bedezup.domain.SystemUser;

public interface SystemUserRestService {
	
	public SystemUser save(SystemUser systemUser);
	
	public SystemUser update(SystemUser systemUser);

	public SystemUser findSystemUserByUserNameAndPasswordEqual(String userName, String password);
	
	public SystemUser findSystemUserByEmailEquals(String email);
	
	public SystemUser findSystemUserByUserNameEquals(String userName);
}
