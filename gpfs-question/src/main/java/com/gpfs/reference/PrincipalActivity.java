package com.gpfs.reference;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.gpfs.core.model.BaseEntity;

@Entity(name = "ref_principal_activity")
public class PrincipalActivity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "type")
	private String type;

	@Column(name = "subtype")
	private String subtype;

	@Column(name = "activity")
	private String activity;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

}
