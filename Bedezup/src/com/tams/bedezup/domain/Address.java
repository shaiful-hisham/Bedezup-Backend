package com.tams.bedezup.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "address")
public class Address implements Serializable {
	
	private static final long serialVersionUID = -2972249566546473722L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "line1")
	private String line1;
	
	@Column(name = "line2")
	private String line2;
	
	@Column(name = "line3")
	private String line3;
	
	@Column(name = "postCode")
	private String postCode;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "state")
	private String state;
}
