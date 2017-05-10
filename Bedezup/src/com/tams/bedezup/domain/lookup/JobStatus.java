package com.tams.bedezup.domain.lookup;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.tams.bedezup.domain.Job;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "jobstatus")
public class JobStatus extends Lookup {
	
	public static final String CODE_UNAPPROVE = "UNAPPR";
	
	public static final String CODE_OPEN = "OP";
	
	public static final String CODE_TAKEN = "TAK";
	
	public static final String CODE_PENDING = "PEND";
	
	public static final String CODE_CLOSE = "CL";
	
	public static final String CODE_REJECTED = "REJ";
	
	private static final long serialVersionUID = 573858212098297409L;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jobStatus")
	private List <Job> jobList;
}
