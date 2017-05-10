package com.tams.bedezup.shared.dto;

import java.io.Serializable;

import lombok.Data;

import com.tams.bedezup.domain.lookup.GoodType;

@Data
public class GoodDTO implements Serializable {
	
	private static final long serialVersionUID = -7235398252721847466L;

	private Long id;
	
	private String goodName;
	
	private String goodDescription;
	
	private GoodType goodType;
}
