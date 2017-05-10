package com.tams.bedezup.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.tams.bedezup.client.ProfileService;
import com.tams.bedezup.domain.Profile;
import com.tams.bedezup.server.dao.ProfileDAO;
import com.tams.bedezup.shared.dto.ProfileDTO;

@Service("profileService")
public class ProfileServiceImpl extends RemoteServiceServlet implements	ProfileService, ProfileRestService {

	private static final long serialVersionUID = 4947258585530691367L;

	@Autowired
	private ProfileDAO profileDAO;
	
	
	/*
	 * Methods for GXT client
	 */
	@Override
	public ProfileDTO findProfileDTOBySystemUserIdEquals(Long systemUserId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * Methods for Restful web service
	 */
	@Override
	public Profile save(Profile profile) {
		return profileDAO.save(profile);
	}
	
	@Override
	public Profile findProfileBySystemUserIdEquals(Long systemUserId) {
		return profileDAO.findProfileBySystemUserIdEquals(systemUserId);
	}
}
