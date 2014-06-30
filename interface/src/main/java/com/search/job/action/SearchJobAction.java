package com.search.job.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionSupport;

public class SearchJobAction extends ActionSupport {
	
	public static String API_KEY = "AAAAA";
	public static String API_VERSION = "v1";
	
	
	protected String getSessionCookies(HttpServletRequest servletRequest) {
		Cookie [] cookies = servletRequest.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().equals("SESSIONID")) {
				return c.getValue();
			}
		}
		return null;
	}
}
