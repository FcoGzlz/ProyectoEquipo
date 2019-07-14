<%-- 
    Document   : verLiga
    Created on : 14-07-2019, 3:14:48
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
        <form action="LigasController" method="POST">
            Nombre: <input type="text" name="nombre">
            
            <button type="submit" value="actualizar" name="boton">Guardar Cambios</button>
            
        </form>
    </body>
</html>
