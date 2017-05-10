package com.tams.bedezup.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "profile")
public class Profile implements Serializable {
	
	private static final long serialVersionUID = -3685337701940103701L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "fullname")
	private String fullName;
	
	@Column(name = "nickname")
	private String nickName;
	
	@Column(name = "contactnumber")
	private String contactNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private SystemUser systemUser;
}
