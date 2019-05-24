<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring JPA</title>
</head>
<style>
.content {
	margin: auto;
}

th, td {
	text-align: center;
	padding: 10px;
}
</style>
<body>
	<div class="content">
		<h2>Todos los Estudiantes</h2>
		<table>
			<tr>
				<th>Accion</th>
				<th>Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Status</th>
			</tr>
			<c:forEach items="${students}" var="students">
				<tr>
					<td><input type="button" class="myButton" value="Editar"
						onclick="location.href='${pageContext.request.contextPath}/editStudent?cStudent=${students.cStudent}'"></td>
					<td>${students.sName}</td>
					<td>${students.lName}</td>
					<td>${students.sAge}</td>
					<td>${students.activoDelegate}</td>
				</tr>
			</c:forEach>
		</table>

		<form:form id="form1" method="post"
			action="${pageContext.request.contextPath}/buscarestudiante">
			<h2>Busqueda de Estudiantes</h2>
			<input type="text" id="code" name="code"
				placeholder="Ingrese el codigo" />
			<input type="submit" class="myButton" value="Buscar" />
		</form:form>

		<h2>Agregar un estudiante</h2>
		<form action="${pageContext.request.contextPath}/saveSt" method="post">
			<input type="submit" value="Agregar un nuevo usuario">
		</form>

		<h2>Eliminar estudiante</h2>
		<form action="${pageContext.request.contextPath}/delete" method="post">
			<input type="text" id="name" name="name"
				placeholder="Inserte nombre">
			<input type="submit" value="Eliminar usuario">
		</form>
	</div>

</body>
</html>