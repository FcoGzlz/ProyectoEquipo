<%-- 
    Document   : verEquipo
    Created on : 14-07-2019, 3:14:30
    Author     : felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="CrearEquipoController" method="POST">
            Escudo: <input type="text" name="escudo">
            Nombre: <input type="text" name="nombre">
            Formacion:<select name="formacion">
                <option value="null">Seleccione Formación</option>
                <option value="4-4-2">4-4-2</option>
                <option value="4-3-1-2">4-3-1-2</option>
                <option value="4-3-3">4-3-3</option>
                <option value="4-2-3-1">4-2-3-1</option>
                <option value="3-5-2">3-5-2</option>
            </select>
            Liga:<select name="liga">
                <option value="null">Seleccione liga</option>
                <c:forEach items="${requestScope.liga}" var="l">
                    <option value="${l.id}">${l.nombre}</option>
                </c:forEach>
            </select>
            <input type="hidden" value="${sessionScope.usuario.rut}" name = "rut">
            <button type="submit" value="actualizar" name="boton">Guardar Cambios</button>   
        </form>
    </body>
</html>
