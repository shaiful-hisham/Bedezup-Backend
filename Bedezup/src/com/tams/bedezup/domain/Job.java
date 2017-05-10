package com.tams.bedezup.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

import org.springframework.format.annotation.DateTimeFormat;

import com.tams.bedezup.domain.lookup.JobStatus;

@Data
@Entity
@Table(name = "job")
public class Job implements Serializable {

	private static final long serialVersionUID = 3708602123510392676L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "publisheddate")
	@Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm a")
	private Date publishedDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private JobStatus jobStatus;
	
	@Column(name = "jobprice")
	private BigDecimal jobPrice;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "job")
	private List <Good> goodList;
}
