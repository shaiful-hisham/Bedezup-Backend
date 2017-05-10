package com.tams.bedezup.server;

import com.tams.bedezup.domain.Profile;

public interface ProfileRestService {

	public Profile save(Profile profile);
	
	public Profile findProfileBySystemUserIdEquals(Long systemUserId);
}
