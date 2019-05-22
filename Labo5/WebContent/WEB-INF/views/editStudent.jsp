<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/save" method="POST" modelAttribute="student">

	<form:input type="hidden" id="cStudent" path="cStudent"/>
	<label>Ingrese un nombre: </label>		
	<form:input type="text" name="name" path="sName"/><br>	
	
	<label>Ingrese un apellido: </label>		
	<form:input type="text" name="lname" path="lName"/><br>	
	
	<label>Ingrese Edad: </label>		
	<form:input type="number" name="age" path="sAge"/><br>	
	
	<label>Estado del estudiante: </label><br>		
	<form:radiobutton name="status" path="bActivo" value="true"/><label>Activo</label><br>
	<form:radiobutton name="status" path="bActivo" value="false"/><label>Inactivo</label><br>
	
	<input type = "submit" value ="Actualizar">

</form:form>
</body>
</html>