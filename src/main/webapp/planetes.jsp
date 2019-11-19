<%@ page import="java.util.ArrayList" %>
<%@ page import="com.esliceu.models.Satelit" %>
<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns:c="http://java.sun.com/jsp/jstl/core">
<body>
    <h3>Satèl·lits</h3>
    <table>
        <thead>
            <th>Nom</th>
            <th>Massa</th>
            <th>Velocitat</th>
            <th>Planeta</th>
            <th>Accions</th>
        </thead>
        <tbody>
            <c:forEach  items="${satelits}" var="satelit" >
                <tr>
                    <td><c:out value="${satelit.idsatelit}"/></td>
                    <td><c:out value="${satelit.nom}"/></td>
                    <td><c:out value="${satelit.massa}"/></td>
                    <td><c:out value="${satelit.velocitat}"/></td>
                    <td><c:out value="${satelit.idplaneta}"/></td>
                    <td><a href="planetesForm.jsp?idsatelit="+${satelit.idsatelit}>Editar</a> </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
