<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>All Pending Details</h2>
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

		<c:forEach items="${list}" var="list">
			<tr>
				<td>${list.id}</td>
				<td>${list.firstName}</td>
				<td>${list.lastName}</td>
				<td>${list.courseName}</td>
				<td>${list.amountPaid}</td>
				<td>${list.totalAmount}</td>
				<td>${list.balanceAmount}</td>
				<td>${list.date}</td>
				<td>${list.email}</td>
				<td>${list.phone}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>