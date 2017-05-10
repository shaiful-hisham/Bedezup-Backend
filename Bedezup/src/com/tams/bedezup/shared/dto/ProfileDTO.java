package com.tams.bedezup.shared.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ProfileDTO implements Serializable {

	private static final long serialVersionUID = -3597221694108747207L;
	
	private Long id;
	
	private String fullName;
	
	private String nickName;
	
	private String contactNumber;
	
	private String email;
	
	private String address;
}
