package com.tams.bedezup.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.tams.bedezup.shared.dto.SystemUserDTO;

public interface SystemUserServiceAsync {

	void findSystemUserDTOByUserNameAndPasswordEqual(String userName, String password, AsyncCallback<SystemUserDTO> callback);

}
