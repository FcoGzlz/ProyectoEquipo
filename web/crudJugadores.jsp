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
        <form action="crearJugadorController" method="POST" enctype="multipart/form-data">
            Nombre: <input type="text" name="nombre">
            Posición: <input type="text" name="position">
            Foto : <input type="file" name="foto">
            <button type ="submit">Agregar</button>
        </form>
        <table>
            <tr>
                <th>Nombre</th>
                <th>Posción</th>
            </tr>
            <tr>
                <c:forEach items="${requesScope.jugadores}" var="j">
                    <td>${j.nombre}</td>
                    <td>${j.posicion}</td>
                </c:forEach>
            </tr>
        </table>
        ${requestScope.msg}
    </body>
</html>
