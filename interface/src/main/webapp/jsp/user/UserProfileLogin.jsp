<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.search.job.rest.response.Error" %>
<%@page import="java.util.List" %>
<html>
	<head>
		<title>User Login</title>
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
		
		<form name="login" id="loginForm" action="http://localhost:8181/SearchJob/profile/authenticate" method="post">
				<label>User Name</label>
				<input type="text" maxlength="50" id="email" name="email" value='<s:property value="email" />'>
		
				<label>Password</label>
				<input type="password" maxlength="50" name="password" id="password">
		
				<button title="Login"><span>Login</span></button>
		</form>
	</body>
</html>