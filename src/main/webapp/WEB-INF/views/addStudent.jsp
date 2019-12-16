<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%-- <form:form method="post" action="save"> --%>
	<form method="POST" action="save">

		StudentName:<input type="text" name="name" /> <br>
		 Degree:<input type="text" name="dgree" /> <br> 
			Desgination :<input type="text" name="desgination" /> <br>
			 Address: <input type="text" name="address" /> <br> 
			<input type="submit" value="submit" />

	</form>



</body>
</html>