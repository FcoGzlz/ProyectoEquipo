<%-- 
    Document   : createUserTest
    Created on : 07-07-2019, 3:26:28
    Author     : Francisco
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
        <h1>Create User test</h1>
        
        <form action ="crearUsuarioController" method="POST">
            RUT <input type="text" name="rut">
            Nombre: <input type="text" name="nombre">
            Apellido <input type="text" name="apellido">
            
            
            <select name="tipoCuenta">
                <option selected value = "null">Seleccione tipo de cuenta</option>
                <option value="0">Estándar</option>
                <option value="1">Administrador</option>
            </select>
            <button type="submit" name="boton" value="crear">Agregar</button>
        
        ${requestScope.msg}
        
        <table>
            <tr>
                <th>Nombre</th>
                <th>Opciones</th>
            </tr>
            
                <c:forEach items="${requestScope.usuarios}" var="u">
                    <tr>
                    <td>${u.nombre}</td>
                    <td><button value="${u.rut}_leer" name="boton">Ver</button>
                        <button value="${u.rut}_eliminar" name="boton">Eliminar</button></td>
                    </tr>
                </c:forEach>
            
            
        </table>
        </form>
    </body>
</html>
