package com.search.job.rest.candidate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.search.job.models.UserProfile;
import com.search.job.rest.BaseDataUtil;
import com.search.job.rest.response.BaseResponse;
import com.search.job.rest.response.Error;
import com.search.job.rest.response.FailureResponse;

public class CandidateUtils extends BaseDataUtil {
	
	
	public static BaseResponse getCandidateByUserName(String userName)  {
		
		List<Error> errors = new ArrayList<Error>();
		
		Query q = new Query();
		
		q.addCriteria(Criteria.where("email").is(userName));
		
		List<UserProfile> users = getMongoTemplate().find(q, UserProfile.class);
		
		if (users.isEmpty()) {
			Error error = new Error("USER101", "User Not Exist...");
			errors.add(error);
			com.search.job.rest.response.BaseResponse response = new FailureResponse(200, errors);
			return response;
		}
		
		BaseResponse response = new com.search.job.rest.response.SucessResponse(users.get(0));
		return response;
	}

}
