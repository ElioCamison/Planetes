<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns:c="http://java.sun.com/jsp/jstl/core">
<body>
<table>
    <thead>
        <th>id</th>
        <th>Nom</th>
        <th>Massa</th>
        <th>Es habitable</th>
    </thead>
    <tbody>
    asdadasdssads
    ${planetes.get(0).id}
<c:forEach  items="${planetes}" var="planeta" >
    <c:out value="${planeta.id}"/>
    aaaa
${planeta}
<tr>
            <td>${ planeta.id }</td>
            <td>${ planeta.nom }</td>
            <td>${ planeta.massa }</td>
            <td>${ planeta.habitable }</td>
        </tr>
</c:forEach>

    </tbody>

</table>
</body>
</html>
