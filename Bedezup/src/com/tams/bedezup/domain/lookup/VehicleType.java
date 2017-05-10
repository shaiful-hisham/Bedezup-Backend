package com.tams.bedezup.domain.lookup;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "vehicletype")
public class VehicleType extends Lookup {
	
	private static final long serialVersionUID = -6156629388835218865L;
}
