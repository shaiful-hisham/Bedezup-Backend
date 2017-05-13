package com.tams.bedezup.domain.lookup;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tams.bedezup.domain.SystemUser;

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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "systemUserType")
	private List<SystemUser> systemUserList;
}
