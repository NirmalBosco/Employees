<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Employees List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Degree</th>
			<th>Desgination</th>
			<th>Address</th>

		</tr>
		<c:forEach var="stu" items="${list}">
			<tr>
				<td>${stu.id}</td>
				<td>${stu.name}</td>
				<td>${stu.dgree}</td>
				<td>${stu.desgination}</td>
				<td>${stu.address}</td>
				<td><a href="editemp/${stu.id}">Edit</a></td>
				<td><a href="deleteStudent/${stu.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="student">Add New Employee</a>


</body>
</html>