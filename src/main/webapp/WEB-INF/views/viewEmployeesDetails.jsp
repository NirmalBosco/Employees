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
			<th>position</th>
			<th>Education</th>
			<th>PhoneNumber</th>
			<th>Address</th>
			<th>State</th>
			<th>Country</th>
			<th>Edit</th>
			<th>Delete</th>

		</tr>
		<c:forEach var="emp" items="${employees}">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.position}</td>
				<td>${emp.education}</td>
				<td>${emp.phonenumber}</td>
				<td>${emp.address}</td>
				<td>${emp.state}</td>
				<td>${emp.country}</td>
				
				<td><a href="empedit/${emp.id}">Edit</a></td>
				<td><a href="deleteemployee/${emp.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="student">Add New Employee</a>


</body>
</html>