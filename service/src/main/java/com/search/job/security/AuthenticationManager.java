package com.search.job.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author jyoti.yadav@globallogic.com
 */
public class AuthenticationManager extends AbstractUserDetailsAuthenticationProvider {

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetail, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
	}

	@Override
	protected UserDetails retrieveUser(String arg0,	UsernamePasswordAuthenticationToken token) throws AuthenticationException {
		Collection<GrantedAuthority> dbAuth = new ArrayList<GrantedAuthority>();
		GrantedAuthority roleAdmin = new GrantedAuthorityImpl("ROLE_USER");
 		dbAuth.add(roleAdmin);
		User userDetails = new User("admin", "passw0rd#",true, true, true, true, dbAuth);
		return userDetails;
	}
}
