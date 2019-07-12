<%-- 
    Document   : crearEquipo
    Created on : 11-07-2019, 21:54:57
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
        <form action="EquipoController" method="POST">
           
            Escudo: <input type="text" name="escudo">
            Nombre: <input type="text" name="nombre">
            Formacion: <input type="text" name="formacion">
            Liga:<select name="liga">
                <option value="null">Seleccione liga</option>
                <c:forEach items="${requestScope.liga}" var="l">
                    <option value="${l.id}">${l.nombre}</option>
                </c:forEach>
            </select>
            <input type="hidden" value="${sessionScope.usuario.rut}" name = "rut">
            
            <button type="submit">Crear</button>
            
        </form>
    </body>
</html>
