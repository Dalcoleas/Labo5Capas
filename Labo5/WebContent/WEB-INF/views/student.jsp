<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Estudiante</title>
</head>
<body>

<h2>Info del Estudiante</h2>

		<c:if test="${not empty resultado}">
			<h3>No hay info del estudiante.</h3>
		</c:if>
		<table cellpadding="5" border="1">
			<tr>
				<td><b>Nombre:</b></td>
				<td>${student.sName}</td>
			</tr>
			<tr>
				<td><b>Apellido:</b></td>
				<td>${student.lName}</td>
			</tr>
			<tr>
				<td><b>Edad:</b></td>
				<td>${student.sAge}</td>
			</tr>
			<tr>
				<td><b>Estado: </b></td>
				<td>${student.activoDelegate}</td>
			</tr>
		</table>
</body>
</html>