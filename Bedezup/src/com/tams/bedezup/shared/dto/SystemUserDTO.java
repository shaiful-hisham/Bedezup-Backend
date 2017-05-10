package com.tams.bedezup.shared.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SystemUserDTO implements Serializable {

	private static final long serialVersionUID = 1424684839022298416L;

	private Long id;
	
	private String userName;

	private String password;
}
