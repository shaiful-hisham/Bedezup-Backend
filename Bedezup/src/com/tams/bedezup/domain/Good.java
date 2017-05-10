package com.tams.bedezup.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

import com.tams.bedezup.domain.lookup.GoodType;

@Data
@Entity
@Table(name = "good")
public class Good implements Serializable {
	 
	private static final long serialVersionUID = 1074004351482587020L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "goodname")
	private String goodName;
	
	@Column(name = "gooddescription")
	private String goodDescription;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private GoodType goodType;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Job job;
}
