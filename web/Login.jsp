<%-- 
    Document   : Login
    Created on : 04-07-2019, 21:26:18
    Author     : 20317815-8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form>
            <div class="form-group">
                <label for="rut">Rut</label>
                <input type="text" class="form-control" id="rut" placeholder="Ingresa Rut">
            </div>
            
            <div class="form-group">
                <label for="contrasena">Contraseña</label>
                <input type="password" class="form-control" id="contrasena" placeholder="Contraseña">
            </div>
            
            <button type="submit" class="btn btn-primary">Entrar</button>
            
        </form>
    </body>
</html>
