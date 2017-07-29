package com.gpfs.gpfs;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.gpfs.core.model.BaseEntity;
import com.gpfs.reference.PrincipalActivity;

@Entity(name = "gpfs")
public class Gpfs extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "pa_id")
	private PrincipalActivity principalActivity;

}
