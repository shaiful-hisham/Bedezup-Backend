package com.tams.bedezup.domain.lookup;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ridertype")
public class RiderType extends Lookup {
	
	private static final long serialVersionUID = -9099949924540466157L;
}
