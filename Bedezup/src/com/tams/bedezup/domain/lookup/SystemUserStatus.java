package com.tams.bedezup.domain.lookup;

public enum SystemUserStatus {
	
	Registered ("Registered"),
	Active ("Active"),
	InActive ("InActive");
	
	private final String statusString;
	
	
	private SystemUserStatus(String statusString) {
		this.statusString = statusString;
	}
	
	public boolean equals(String string) {
		return statusString.equals(string);
	}
	
	public String toString() {
		return statusString;
	}
}
