<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring JPA</title>
</head>
<body>
	<table>
		<tr>
			<th>Name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Status</th>
		</tr>
			<c:forEach items="${students}" var ="students">
				<tr>
					<td>${students.sName}</td>
					<td>${students.lName}</td>
					<td>${students.sAge}</td>
					<td>${students.activoDelegate}</td>
				</tr>
			</c:forEach>
	</table>
	
		<form:form id="form1" method="post" action="${pageContext.request.contextPath}/buscarestudiante">
		<h2>Busqueda de Estudiantes</h2>
		<table cellpadding="5">
			<tr>
				<td><input type="text" id="code" name="code" placeholder="Ingrese el codigo" /></td> 
			</tr>
			<tr>
				<td><input type="submit" class="myButton" value="Buscar"" />
			</tr>
		</table>
		</form:form>
</body>
</html>