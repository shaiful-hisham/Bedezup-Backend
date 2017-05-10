package com.tams.bedezup.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.tams.bedezup.shared.dto.ProfileDTO;

@RemoteServiceRelativePath("springGwtServices/profileService")
public interface ProfileService extends RemoteService {
	
	public ProfileDTO findProfileDTOBySystemUserIdEquals(Long systemUserId);
}
