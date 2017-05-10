package com.tams.bedezup.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.tams.bedezup.domain.SystemUser;
import com.tams.bedezup.shared.UserState;

public interface SecurityServiceAsync {

	void login(String userName, String password, AsyncCallback <UserState> callback);

	void logout(AsyncCallback <UserState> callback);

	void getCurrentLoggedInSystemUser(AsyncCallback <SystemUser> callback);
	
	void getCurrentLoggedInSystemUserState(AsyncCallback <UserState> callback);
}
