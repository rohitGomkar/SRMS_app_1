<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>reports</title>
</head>
<body>
<table border='1'>
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>LAST NAME</th>
			<th>COURSE NAME</th>
			<th>AMOUNT PAID</th>
			<th>TOTAL AMOUNT</th>
			<th>BALANCE AMOUNT</th>
			<th>DATE</th>
			<th>EMAIL ID</th>
			<th>MOBILE NO</th>
		</tr>

		<c:forEach items="${reports}" var="reports">
			<tr>
				<td>${reports.id}</td>
				<td>${reports.firstName}</td>
				<td>${reports.lastName}</td>
				<td>${reports.courseName}</td>
				<td>${reports.amountPaid}</td>
				<td>${reports.totalAmount}</td>
				<td>${reports.balanceAmount}</td>
				<td>${reports.date}</td>
				<td>${reports.email}</td>
				<td>${reports.phone}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>