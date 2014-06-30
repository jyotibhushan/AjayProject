package com.search.job.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;
import com.search.job.models.UserProfile;
import com.search.job.rest.candidate.CandidateUtils;
import com.search.job.rest.login.LoginPO;
import com.search.job.rest.login.LoginVO;
import com.search.job.rest.response.BaseResponse;
import com.search.job.rest.response.Error;
import com.search.job.rest.response.FailureResponse;
import com.search.job.rest.response.SucessResponse;
import com.search.job.rest.signup.AuthenticationUtil;
import com.search.job.rest.signup.SignupPO;
import com.search.job.security.utils.TokenHolderObject;
import com.search.job.security.utils.TokenUtils;

public class RegistrationAction extends SearchJobAction implements ServletResponseAware, ServletRequestAware {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String confirmPassword;
	private UserProfile userProfile;
	private List<Error> screenErrors;
	
	protected HttpServletResponse servletResponse;
	protected HttpServletRequest servletRequest;
	
	
	public String login() {
		return Action.SUCCESS;
	}
 	
	public String authenticate() {
		
		LoginPO loginPO = new LoginPO(getEmail(), getPassword());
		
		BaseResponse response = AuthenticationUtil.login(API_KEY, API_VERSION, loginPO);
		
		if (response instanceof FailureResponse) {
			screenErrors = ((FailureResponse) response).getErrors();
			return Action.ERROR;
		}
		
		if (response instanceof com.search.job.rest.response.SucessResponse) {
			try {
				
				LoginVO login = ((LoginVO) ((SucessResponse) response).getPayload());
				Cookie cookies = new Cookie("SESSIONID", login.getToken());
				servletResponse.addCookie(cookies);
				servletResponse.sendRedirect("http://localhost:8181/SearchJob/profile/view");
			} catch (IOException e) {
			}
		}
		return Action.ERROR;
	}
	
	
	public String registerCandidate() {
		return Action.SUCCESS;
	}
	
	
	public String signup() {
		
		SignupPO signupPO = new SignupPO(getEmail(), getFirstName(), getLastName(), getPassword(), getConfirmPassword());
		
		BaseResponse response = AuthenticationUtil.signUP(API_KEY, API_VERSION, signupPO);
		
		if (response instanceof FailureResponse) {
			screenErrors = ((FailureResponse) response).getErrors();
			return Action.ERROR;
		} else {
			LoginVO login = ((LoginVO) (((SucessResponse) response).getPayload()));
			Cookie cookies = new Cookie("SESSIONID", login.getToken());
			servletResponse.addCookie(cookies);
			
			try {
				servletResponse.sendRedirect("http://localhost:8181/SearchJob/profile/view");
			} catch (IOException e) {
			}
			return Action.SUCCESS;
		}
	}
	
	public String view() {
		String cookiesValue = getSessionCookies(servletRequest);
		
		if (cookiesValue == null) {
		}
		
		TokenHolderObject tokenHolderObject = TokenUtils.getUserFromToken(cookiesValue);
		
		if (tokenHolderObject == null) {
			
		}

		BaseResponse response = CandidateUtils.getCandidateByUserName(tokenHolderObject.getUserName());
		
		userProfile = ((UserProfile) ((com.search.job.rest.response.SucessResponse) response).getPayload());
		
		return Action.SUCCESS;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public List<Error> getScreenErrors() {
		return screenErrors;
	}


	public void setScreenErrors(List<Error> screenErrors) {
		this.screenErrors = screenErrors;
	}


	@Override
	public void setServletResponse(HttpServletResponse servletResponse) {
		this.servletResponse = servletResponse;
	}


	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}


	public UserProfile getUserProfile() {
		return userProfile;
	}


	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
}
