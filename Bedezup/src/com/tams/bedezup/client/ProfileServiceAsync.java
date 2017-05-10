package com.tams.bedezup.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.tams.bedezup.shared.dto.ProfileDTO;

public interface ProfileServiceAsync {

	void findProfileDTOBySystemUserIdEquals(Long systemUserId, AsyncCallback<ProfileDTO> callback);
	
}
