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
@Table(name = "geolocation")
public class GeoLocation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "latitude")
	private double latitude;
	
	@Column(name = "longitude")
	private double longitude;
	
}
