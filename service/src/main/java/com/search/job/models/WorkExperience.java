package com.search.job.models;

import org.springframework.data.annotation.Id;

public class WorkExperience extends SearchJobBaseModel{

	@Id
	private String id;

	private String company;
	private String title;
	private String location;

	private String startMonth;
	private int startMonthIndex;
	private int startYear;

	private String endMonth;
	private int endMonthIndex;
	private int endYear;

	private boolean currentlyWorkingHere;
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	public int getStartMonthIndex() {
		return startMonthIndex;
	}

	public void setStartMonthIndex(int startMonthIndex) {
		this.startMonthIndex = startMonthIndex;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public String getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}

	public int getEndMonthIndex() {
		return endMonthIndex;
	}

	public void setEndMonthIndex(int endMonthIndex) {
		this.endMonthIndex = endMonthIndex;
	}

	public int getEndYear() {
		return endYear;
	}

	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}

	public boolean isCurrentlyWorkingHere() {
		return currentlyWorkingHere;
	}

	public void setCurrentlyWorkingHere(boolean currentlyWorkingHere) {
		this.currentlyWorkingHere = currentlyWorkingHere;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
