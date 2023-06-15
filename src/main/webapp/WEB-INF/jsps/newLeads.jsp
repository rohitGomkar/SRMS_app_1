<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>New Lead</h2>
       <form action="saveLeads" method="post">
       <pre>
       FIRST NAME <input type="text" name="firstName">
       LAST NAME <input type="text" name="lastName">
       EMAIL ID  <input type="text" name="email">
       MOBILE NO <input type="text" name="phone">
       <label for="leadSource">Choose a LEAD SOURCE:</label>
		
  		<select name="leadSource" id="leads">
   		 	<option value="newspaper">Newspaper</option>
    	 	<option value="socialMedia">SocialMedia</option>
    	 	<option value="friends">Friends</option>
    	 	<option value="other">Other</option>
 		</select>
 		<input type="submit" value="save"/>
 		</pre> 
       </form>
       ${msg}
</body>
</html>