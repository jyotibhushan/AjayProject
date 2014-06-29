package com.search.job.models;

public class CandidateSkills extends SearchJobBaseModel {

	private String skillName;
	private Integer skillIdentifier;

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Integer getSkillIdentifier() {
		return skillIdentifier;
	}

	public void setSkillIdentifier(Integer skillIdentifier) {
		this.skillIdentifier = skillIdentifier;
	}
}
