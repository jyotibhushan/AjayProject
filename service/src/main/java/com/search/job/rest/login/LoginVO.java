package com.search.job.rest.login;

import java.io.Serializable;

import com.search.job.models.UserProfile;

public class LoginVO implements Serializable {

	private String token;

	private UserProfile userProfile;
	
	public LoginVO(){
	}
	
	public LoginVO(String token, UserProfile userProfile){
		this.token = token;
		this.userProfile = userProfile;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
}
