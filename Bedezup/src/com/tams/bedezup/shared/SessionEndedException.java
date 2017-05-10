package com.tams.bedezup.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class SessionEndedException extends Exception implements IsSerializable {
	
	private static final long serialVersionUID = 1L;
	
	private String errorMessage;
	
	
	public SessionEndedException() {
		super();
	}
	
	public SessionEndedException(String msg) {
		super(msg);
	}
	
	public SessionEndedException(Throwable e) {
		super(e.getMessage());
		
		if (e instanceof SessionEndedException) {
        	setErrorMessage( ((SessionEndedException)e).getErrorMessage() );
        }
	}
	
	public SessionEndedException(String msg, String errorMessage) {
        super(msg);
        setErrorMessage(errorMessage);
    }
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
