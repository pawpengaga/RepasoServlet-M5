<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.taglibs.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>Usuarios</h2>

    <table>
        <thead>
            <tr>
                <th>Nombre</tr>
                <th>Usuario</th>
                <th>Opciones</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${empty users}">
                <p>No hay usuarios registrados...</p>
            </c:if>
            <c:if test="${not empty users}">
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.nombre}</td>
                        <td>${user.usuario}</td>
                        <td>
                            <div>Editar</div>
                            <div>Eliminar</div>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
        </tbody>
    </table>

</body>
</html>