package com.tams.bedezup.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tams.bedezup.domain.lookup.VehicleType;

import lombok.Data;

@Data
@Entity
@Table(name = "vehicle")
public class Vehicle implements Serializable {
	
	private static final long serialVersionUID = 3947234554352914896L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "brandmodel")
	private String brandModel;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private VehicleType vehicleType;
}
