package com.search.job.models;

import java.util.Set;
import java.util.TreeSet;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "UserProfile")
public class UserProfile extends SearchJobBaseModel {

	@Id
	private String id;

	private String firstName;

	private String lastName;

	@Indexed
	private String email;
	
	@Indexed
	private String password;

	private String jobTitle;

	private String area;

	private String summary;
	
	private String location;
	
	private String locationId;

	private Set<WorkExperience> workExperience = new TreeSet<WorkExperience>();

	private Set<EducationExperience> educationExperience = new TreeSet<EducationExperience>();

	private Set<CandidateSkills> skills = new TreeSet<CandidateSkills>();
	
	public UserProfile(){
	}
	
	public UserProfile(String firstName, String lastName, String email, String password, String location){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Set<WorkExperience> getWorkExperience() {
		return workExperience;
	}

	public void setWorkExperience(Set<WorkExperience> workExperience) {
		this.workExperience = workExperience;
	}

	public Set<EducationExperience> getEducationExperience() {
		return educationExperience;
	}

	public void setEducationExperience(
			Set<EducationExperience> educationExperience) {
		this.educationExperience = educationExperience;
	}

	public Set<CandidateSkills> getSkills() {
		return skills;
	}

	public void setSkills(Set<CandidateSkills> skills) {
		this.skills = skills;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
}
