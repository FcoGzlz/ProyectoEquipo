<%-- 
    Document   : Login
    Created on : 04-07-2019, 21:26:18
    Author     : 20317815-8
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="template.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="LoginController" method="POST">
            <div class="form-group">
                <label for="rut">Rut</label>
                <input type="text" class="form-control" id="rut" placeholder="Ingresa Rut" name="rut">
            </div>
            
            <div class="form-group">
                <label for="contrasena">Contraseña</label>
                <input type="password" class="form-control" id="clave" placeholder="Contraseña" name="clave">
            </div>
            
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="tipoDeCuenta">Cuenta</label>
                </div>
                <select class="custom-select" id="tipoDeCuenta" name="estado">
                    <option selected value="null">Seleccione tipo de Cuenta</option>
                    <option value="0">Usuario</option>
                    <option value="1">Administrador</option>
                </select>
            </div>
            
            <button type="submit" class="btn btn-primary">Entrar</button>
        </form>
        ${requestScope.msg}
    </body>
</html>
