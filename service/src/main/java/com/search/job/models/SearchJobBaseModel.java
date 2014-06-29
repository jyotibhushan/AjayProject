package com.search.job.models;

import java.io.Serializable;
import java.util.Date;

public class SearchJobBaseModel implements Serializable {

	private static final long serialVersionUID = -797066298380361410L;
	
	private Date createdDate = new Date();
	private String createdBy =  "Jboss";
	private Date updatedDate;
	private String updatedBy;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
