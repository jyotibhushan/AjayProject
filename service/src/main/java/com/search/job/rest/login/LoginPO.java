package com.search.job.rest.login;

import java.io.Serializable;

/**
 * @author jyoti.yadav@globallogic.com
 */
public class LoginPO implements Serializable {

	private static final long serialVersionUID = 85783916826497792L;

	private String username;
	private String password;
	
	public LoginPO(){
	}
	
	public LoginPO(String username, String password){
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
