package com.tams.bedezup.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.tams.bedezup.domain.lookup.SystemUserType;

import lombok.Data;

@Data
@Entity
@Table(name = "systemuser")
public class SystemUser implements Serializable {
	
	private static final long serialVersionUID = 8948040782661661815L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "status")
	private String status;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "systemUser")
	private Profile profile;
	
	@ManyToOne
	private SystemUserType userType;
	
	
	
}
