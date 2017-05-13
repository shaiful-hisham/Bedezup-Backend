/**
 * 
 */
package com.tams.bedezup.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Shaiful Hisham Mat Jali
 *
 */

@Data
@Entity
@Table(name = "organisation")
public class Organisation implements Serializable {
	
	private static final long serialVersionUID = -8106768200078416518L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "name")
	private String orgName;
	
	
}
