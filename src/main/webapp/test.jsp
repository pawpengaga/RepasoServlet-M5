<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>
<!-- https://www.tutorialspoint.com/jsp/jsp_standard_tag_library.htm -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- c:set para definir variables -->
    <c:set var="nombre" value="Rhea" />
    <c:set var="edad" value="19" />
    <c:set var="pais" value="Nose" />

    <!-- JSTL puede ser usado con fn: para conseguir mas funciones -->
    <h2>Información</h2>
    <p>Nombre: <c:out value="${nombre}" /></p>
    <p>Edad: <c:out value="${edad}" /></p>
    <p>País: <c:out value="${pais}" /></p>
    <p>Nombre longitud: ${fn:length(nombre)}</p>

</body>
</html>