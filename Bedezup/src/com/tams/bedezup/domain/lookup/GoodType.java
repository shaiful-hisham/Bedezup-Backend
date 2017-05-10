package com.tams.bedezup.domain.lookup;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.tams.bedezup.domain.Good;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "goodtype")
public class GoodType extends Lookup {
	 
	private static final long serialVersionUID = 1516728671018434598L;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "goodType")
	private List <Good> goodList;
}
