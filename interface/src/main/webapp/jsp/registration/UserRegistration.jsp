<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.search.job.rest.response.Error" %>
<%@page import="java.util.List" %>
<html>
	<head>
		<title>User Registration</title>
	</head>
	
	<body>
	
		<%
	        	Object errorMsg = request.getAttribute("screenErrors");
	        	if(errorMsg != null){
	        		
	        		List<Error> errors = (List<Error>)  errorMsg;
	        		
	        		for (Error error : errors) { %>
	        			<label><%= error.getErrorDescription() %></label>
	     <%   		}
	        		
	        	}
		%>
		
		<form name="registration" id="registrationForm" action="http://localhost:8181/SearchJob/profile/signup" method="post">
			
			<label>First Name</label>
			<input type="text" maxlength="50" id="firstName" name="firstName" value='<s:property value="firstName" />'>
			
			<label>Last Name</label>
			<input type="text" maxlength="50" id="lastName" name="lastName" value='<s:property value="lastName" />'>
			
			<label>User Email</label>
			<input type="text" maxlength="50" id="email" name="email" value='<s:property value="email" />'>
			
			<label>Password</label>
			<input type="password" maxlength="50" name="password" id="password">
			
			<label>Confirm Password</label>
			<input type="password" maxlength="50" name="confirmPassword" id="confirmPassword">
			
			
			<button title="Sign Up"><span>Sign Up</span></button>
		</form>
	</body>
</html>