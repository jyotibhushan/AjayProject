package com.search.job.rest.signup;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.search.job.rest.BaseRestAPI;
import com.search.job.rest.response.BaseResponse;
import com.sun.jersey.api.JResponse;

@Path("/{version}/signup")
public class CandidateSignupAPI extends BaseRestAPI{
	
	
	@Path("/candidate")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public JResponse<BaseResponse> signUpCandidate(@HeaderParam("X-API-KEY") String apiKey, @PathParam("version") String version, SignupPO signupVO){
		return AuthenticationUtil.signUP(apiKey, version, signupVO);
	}
}
