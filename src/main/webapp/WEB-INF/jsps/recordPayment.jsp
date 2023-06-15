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
<h2>Record Payment</h2>
        <form action="saveRecords" method="post">
        <pre>
        ID<input type="text" name="id" value="${leads.id}">
        FIRST NAME<input type="text" name="firstName" value="${leads.firstName}">
        LAST NAME<input type="text" name="lastName" value="${leads.lastName}">
        COURSE NAME<input type="text" name="courseName">
        AMOUNT PAID<input type="text" name="amountPaid">
        TOTAL AMOUNT<input type="text" name="totalAmount">
        BALANCE AMOUNT<input type="text" name="balanceAmount">
        DATE<input type="text" name="date"/>
        EMAIL ID <input type="text" name="email" value="${leads.email}">
        MOBILE NO<input type="text" name="phone" value="${leads.phone}">
                  <input type="submit" value="save">
        </pre>
        </form>
</body>
</html>