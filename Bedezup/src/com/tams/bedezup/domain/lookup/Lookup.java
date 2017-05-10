package com.tams.bedezup.domain.lookup;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Lookup implements Serializable {

	private static final long serialVersionUID = -1282058661949541503L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "textString")
	private String textString;
}
