<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.search.job.models.UserProfile" %>
<html>
	<head>
		<title>User Profile</title>
	</head>
	<body>
		<%		
	        	Object object = request.getAttribute("userProfile");
	        	if(object != null){
	        		UserProfile userProfile = (UserProfile)  object; %>
	        		<label>First Name</label>
					<label><%=  userProfile.getFirstName() %></label>
					
					<label>Last Name</label>
					<label><%=  userProfile.getLastName() %></label>
					
					<label>Email</label>
					<label><%=  userProfile.getEmail() %></label>
	    <%   	}
		%>
	</body>
</html>