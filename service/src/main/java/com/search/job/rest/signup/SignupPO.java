package com.search.job.rest.signup;

import java.io.Serializable;

public class SignupPO implements Serializable {

	private static final long serialVersionUID = 2932967150408255113L;

	private String email;

	private String firstName;
	private String lastName;
	private String password;
	private String confirmPassword;
	
	public SignupPO(){
	}
	
	public SignupPO(String email, String firstName, String lastName, String password, String confirmPassword){
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
