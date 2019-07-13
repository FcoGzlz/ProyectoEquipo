<%-- 
    Document   : verUsuario
    Created on : 13-07-2019, 2:04:50
    Author     : Francisco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="crearUsuarioController" method="POST">
            <input type="hidden" value="${requestScope.usuario.id}" name="id">
        RUT: <input type="text" value="${requestScope.usuario.rut}" name="rut">
        Nombre: <input type="text" value="${requestScope.usuario.nombre}" name="nombre">
        Apellido: <input type="text" value="${requestScope.usuario.apellido}" name="apellido">
        Tipo de Cuenta: <select name="tipoCuenta">
            <option value="${requestScope.usuario.esadministrador}" selected>${requestScope.tipoCuentaActual}</option>
            <option value="${requestScope.tipoCuentaBool}">${tipoCuenta}</option>
        </select>
        <button type="submit" value="actualizar" name="boton">Guardar Cambios</button>
        <button type="submit" value="cancelar" name="boton">Cancelar</button>
        </form>
    </body>
</html>
