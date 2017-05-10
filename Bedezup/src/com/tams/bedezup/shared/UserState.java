package com.tams.bedezup.shared;

import java.io.Serializable;
import java.util.HashMap;

public class UserState implements Serializable {

	private static final long serialVersionUID = 4060011919946821197L;

	public static final String USER_STATE = "userState";
		
	public static final String SYSTEM_USER_ID = "SYSTEM_USER_ID";
	
	public static final String LAST_LOGIN = "LAST_LOGIN";
	
	public static final String LAST_LOGOUT = "LAST_LOGOUT";
	
	public static final String REDIRECT_STRING = "REDIRECT_STRING";
		
	private String sessionId;
	
	private HashMap <String, Object> stateMap = new HashMap <String, Object>();

	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Object getStateObject(String key) {
		return stateMap.get(key);
	}

	public void setStateObject(String key, Object obj) {
		this.stateMap.put(key, obj);
	}
}
