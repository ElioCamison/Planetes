<%@ page import="java.util.ArrayList" %>
<%@ page import="com.esliceu.models.Satelit" %>
<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns:c="http://java.sun.com/jsp/jstl/core">
<head>
    <title>Inicio de sesión</title>
</head>
<body>
<h1>Login</h1>
<form action="LoginServlet" method="post">
    <input type="text" name="user" placeholder="usuario">
    <input type="text" name="password" placeholder="usuario">
    <input type="submit" value="iniciar sesion">
</form>

</body>
</html>

