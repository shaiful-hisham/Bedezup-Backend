package com.tams.bedezup.shared.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

import com.tams.bedezup.domain.lookup.JobStatus;

@Data
public class JobDTO implements Serializable {

	private static final long serialVersionUID = -735612977920390118L;

	private Long id;
	
	private String title;
	
	private String description;
	
	private Date publishedDate;
	
	private JobStatus jobStatus;
	
	private BigDecimal jobPrice;
}
