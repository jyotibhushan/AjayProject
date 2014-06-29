package com.search.job.rest.login;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.search.job.rest.BaseRestAPI;
import com.search.job.rest.signup.AuthenticationUtil;
import com.sun.jersey.api.JResponse;

@Path("/{version}/login")
public class LoginRestAPI extends BaseRestAPI {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public JResponse<com.search.job.rest.response.BaseResponse> doLogin(@HeaderParam("X-API-KEY") String apiKey, @PathParam("version") String version, LoginPO login) {
		return AuthenticationUtil.login(apiKey, version, login);
	}
}
