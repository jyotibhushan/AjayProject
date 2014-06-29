package com.search.job.rest.signup;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.search.job.models.UserProfile;
import com.search.job.models.UserSession;
import com.search.job.rest.BaseDataUtil;
import com.search.job.rest.login.LoginPO;
import com.search.job.rest.login.LoginVO;
import com.search.job.rest.response.Error;
import com.search.job.rest.response.FailureResponse;
import com.search.job.rest.response.SucessResponse;
import com.search.job.security.utils.TokenHolderObject;
import com.search.job.security.utils.TokenUtils;
import com.sun.jersey.api.JResponse;

public class AuthenticationUtil extends BaseDataUtil {
	
	public static JResponse<com.search.job.rest.response.BaseResponse> login(String apiKey, String version, LoginPO login) {
		
		List<Error> errors = new ArrayList<Error>();
		
		if (login.getUsername() == null || login.getUsername().isEmpty()) {
			Error error = new Error("Login1", "User name Can not null or empty");
			errors.add(error);
		}
		
		if (login.getPassword() == null) {
			Error error = new Error("LoginP2", "Password Can not null or empty");
			errors.add(error);
		}
		
		if (!errors.isEmpty()) {
			com.search.job.rest.response.BaseResponse response = new FailureResponse(200, errors);
			return JResponse.ok(response).build();
		}
		
		Query q = new Query();
		
		q.addCriteria(Criteria.where("email").is(login.getUsername()).and("password").is(DigestUtils.md5Hex(login.getPassword())));
		
		List<UserProfile> users = getMongoTemplate().find(q, UserProfile.class);
		
		
		if (users.isEmpty() || users.size() > 1) {
			Error error = new Error ("LOGIN3", "Invalid User Name/Password");
			errors.add(error);
			com.search.job.rest.response.BaseResponse response = new FailureResponse(200, errors);
			return JResponse.ok(response).build();
		}
		
		TokenHolderObject tokenHolder = new TokenHolderObject(login.getUsername(), login.getPassword(), "ROLE_USER", Calendar.getInstance().getTimeInMillis());
		
		LoginVO loginVO = new LoginVO(TokenUtils.getToken(tokenHolder), users.get(0));
		
		UserSession userSession = new UserSession(login.getUsername(), Calendar.getInstance().getTime(), loginVO.getToken());
		getMongoTemplate().save(userSession);
		
		com.search.job.rest.response.BaseResponse response = new SucessResponse(loginVO);
		return JResponse.ok(response).build();
	}
	
	public static JResponse<com.search.job.rest.response.BaseResponse> signUP(String apiKey, String version, SignupPO signupVO) {
		
		List<Error> errors = new ArrayList<Error>();
		
		if (signupVO.getEmail() == null || signupVO.getEmail().isEmpty()) {
			Error error = new Error("SIGNUP1", "Email Can not null or empty");
			errors.add(error);
		}
		
		if (signupVO.getFirstName() == null || signupVO.getFirstName().isEmpty()) {
			Error error = new Error("SIGNUP2", "First Name Can not null or empty");
			errors.add(error);
		}
		
		if (signupVO.getLastName() == null || signupVO.getLastName().isEmpty()) {
			Error error = new Error("SIGNUP3", "Last Name Can not null or empty");
			errors.add(error);
		}
		
		if (signupVO.getLocation() == null || signupVO.getLocation().isEmpty()) {
			Error error = new Error("SIGNUP4", "Location Can not null or empty");
			errors.add(error);
		}
		
		
		if (signupVO.getPassword() == null || signupVO.getConfirmPassword() == null || !signupVO.getPassword().equals(signupVO.getConfirmPassword())) {
			Error error = new Error("SIGNUP4", "Password not matches with confirm password");
			errors.add(error);
		}
		
		
		
		if (!errors.isEmpty()) {
			com.search.job.rest.response.BaseResponse response = new FailureResponse(200, errors);
			return JResponse.ok(response).build();
		}
		
		Query q = new Query();
		
		q.addCriteria(Criteria.where("email").is(signupVO.getEmail()));
		
		List<UserProfile> users = getMongoTemplate().find(q, UserProfile.class);
		
		if (users.size() != 0) {
			Error error = new Error("SIGNUP5", "User Already Exist");
			errors.add(error);
			com.search.job.rest.response.BaseResponse response = new FailureResponse(200, errors);
			return JResponse.ok(response).build();
		}
		
		UserProfile userProfile = new UserProfile(signupVO.getFirstName(), signupVO.getLastName(), signupVO.getEmail(), DigestUtils.md5Hex(signupVO.getPassword()), signupVO.getLocation());
		
		getMongoTemplate().save(userProfile);
		
		LoginPO login = new LoginPO(userProfile.getEmail(), signupVO.getPassword());
		
		return login(apiKey, version, login);
	}
}
