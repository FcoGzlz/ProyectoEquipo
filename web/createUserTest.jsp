<%-- 
    Document   : createUserTest
    Created on : 07-07-2019, 3:26:28
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
        <h1>Create User test</h1>
        
        <form action ="crearUsuarioController" method="POST">
            RUT <input type="text" name="rut">
            Nombre: <input type="text" name="nombre">
            Apellido <input type="text" name="apellido">
            Clave <input type="password" name="clave">
            
            <select name="tipoCuenta">
                <option selected value = "null">Seleccione tipo de cuenta</option>
                <option value="0">Estándar</option>
                <option value="1">Administrador</option>
            </select>
            <button type="submit">Agregar</button>
        </form>
        ${requestScope.msg}
    </body>
</html>
