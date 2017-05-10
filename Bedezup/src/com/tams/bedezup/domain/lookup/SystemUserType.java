package com.tams.bedezup.domain.lookup;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "systemusertype")
public class SystemUserType extends Lookup {

	public static final String CODE_ADMINISTRATOR = "ADMIN";
	
	public static final String CODE_SYS_OPERATOR = "OP";
	
	public static final String CODE_RIDER = "RID";
		
	private static final long serialVersionUID = -6410032220358063761L;	
}
