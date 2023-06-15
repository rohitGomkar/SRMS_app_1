<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@include file="menu.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>All Inquiry Details</h2>
	<table border='1'>
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email Id</th>
			<th>Mobile no</th>
			<th>lead Source</th>
			<th>Send Email</th>
			<th>Records</th>
		</tr>
		
		<c:forEach items="${leads}" var="leads">
		<tr>
			<td>${leads.id}</td>
			<td>${leads.firstName}</td>
			<td>${leads.lastName}</td>
			<td>${leads.email}</td>
			<td>${leads.phone}</td>
			<td>${leads.leadSource}</td>
						
			<td><a href="sendEmail?leadsId=${leads.email}">Send Email</a></td>
			<td><a href="records?leadsId=${leads.id}">Records</a></td>
		</tr>
		</c:forEach>		
	</table>
</body>
</html>