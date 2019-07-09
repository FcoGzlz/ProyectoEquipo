<%-- 
    Document   : crudJugadores
    Created on : 04-07-2019, 21:56:58
    Author     : 20278034-2
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Test Crud jugadores</h1>
        <form action="crearJugadorController" method="POST">
            Nombre: <input type="text" name="nombre">
            Posición: <input type="text" name="position">
            Equipo:
            <select name="equipo">
                <option selected value="null">Seleccione Equipo</option>
                <c:forEach items="${requestScope.equipos}" var="e">
                    <option value="${e.id}">${e.nombre}</option>
                </c:forEach>
            </select>
        </form>
    </body>
</html>
