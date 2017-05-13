package com.tams.bedezup.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.tams.bedezup.client.SystemUserService;
import com.tams.bedezup.domain.SystemUser;
import com.tams.bedezup.server.dao.SystemUserDAO;
import com.tams.bedezup.shared.dto.SystemUserDTO;

@Service("systemUserService")
public class SystemUserServiceImpl extends RemoteServiceServlet implements SystemUserService, SystemUserRestService {

	private static final long serialVersionUID = 1622424103283338526L;

	@Autowired
	private SystemUserDAO systemUserDAO;
	
	
	/*
	 * Methods for GXT client
	 */
	@Override
	public SystemUserDTO findSystemUserDTOByUserNameAndPasswordEqual(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * Methods for Restful web service
	 */
	@Override
	public SystemUser save(SystemUser systemUser) {
		return systemUserDAO.save(systemUser);
	}
	
	@Override
	public SystemUser update(SystemUser systemUser) {
		return systemUserDAO.update(systemUser);
	}
	
	@Override
	public SystemUser findSystemUserByUserNameAndPasswordEqual(String userName, String password) {
		return systemUserDAO.findSystemUserByUserNameAndPasswordEqual(userName, password);
	}
	
	@Override
	public SystemUser findSystemUserByEmailEquals(String email) {
		return systemUserDAO.findSystemUserByEmailEquals(email);
	}

	@Override
	public SystemUser findSystemUserByUserNameEquals(String userName) {
		return systemUserDAO.findSystemUserByUserNameEquals(userName);
	}
}
