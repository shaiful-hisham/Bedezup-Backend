package com.tams.bedezup.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.tams.bedezup.domain.SystemUser;
import com.tams.bedezup.shared.SessionEndedException;
import com.tams.bedezup.shared.UserState;


@RemoteServiceRelativePath("springGwtServices/securityService")
public interface SecurityService extends RemoteService {
	
	public UserState login(String userName, String password);
	
	public UserState logout();
	
	public SystemUser getCurrentLoggedInSystemUser() throws SessionEndedException;
	
	public UserState getCurrentLoggedInSystemUserState() throws SessionEndedException;
	
	
	public static class Util {
		
		private static volatile SecurityServiceAsync instance;
		
		
		// Enforce singleton, double checked locking
		public static SecurityServiceAsync getInstance() {
			if (instance == null) {	
				synchronized(Util.class) {
					if (instance == null) {
						instance = GWT.create(SecurityService.class);
						ServiceDefTarget endPoint = (ServiceDefTarget) instance;
						String moduleRelativeURL = GWT.getModuleBaseURL() + "springGwtServices/securityService";
						endPoint.setServiceEntryPoint(moduleRelativeURL);
					}
				}
			}
			
			return instance;
		}
	}

}
