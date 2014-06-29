package com.search.job.security.utils;

import java.io.Serializable;

public class TokenHolderObject implements Serializable {

	private static final long serialVersionUID = 3418753893415386878L;

	private String userName;
	private String password;
	private String role;
	private long lastAccessTime;
	
	public TokenHolderObject(){
	}
	
	public TokenHolderObject(String username, String password, String role, long lastAccessTime){
		this.userName = username;
		this.password = password;
		this.role = role;
		this.lastAccessTime = lastAccessTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(long lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
